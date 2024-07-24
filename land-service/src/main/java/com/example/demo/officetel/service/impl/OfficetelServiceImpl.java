package com.example.demo.officetel.service;

import com.example.demo.officetel.domain.OfficetelDTO;
import com.example.demo.officetel.domain.OfficetelMapper;
import com.example.demo.officetel.domain.OfficetelModel;
import com.example.demo.officetel.repository.OfficetelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OfficetelServiceImpl implements OfficetelService {

    private final OfficetelMapper officetelMapper;
    private final OfficetelRepository officetelRepository;

    @Autowired
    public OfficetelServiceImpl(OfficetelMapper officetelMapper, OfficetelRepository officetelRepository) {
        this.officetelMapper = officetelMapper;
        this.officetelRepository = officetelRepository;
    }

    @Override
    public Flux<OfficetelDTO> getAllOfficetels() {
        return officetelRepository.findAll()
                .map(officetelMapper::toDTO);
    }

    @Override
    public Mono<OfficetelDTO> getOfficetelById(String id) {
        return officetelRepository.findById(id)
                .map(officetelMapper::toDTO)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Officetel not found")));
    }

    @Override
    public Mono<OfficetelDTO> createOfficetel(OfficetelDTO officetelDTO) {
        OfficetelModel model = officetelMapper.toModel(officetelDTO);
        return officetelRepository.save(model)
                .map(officetelMapper::toDTO);
    }

    @Override
    public Mono<OfficetelDTO> updateOfficetel(String id, OfficetelDTO officetelDTO) {
        return officetelRepository.findById(id)
                .flatMap(existingOfficetel -> {
                    existingOfficetel.setAtclNo(officetelDTO.getAtclNo());
                    existingOfficetel.setAtclNm(officetelDTO.getAtclNm());
                    existingOfficetel.setRletTpNm(officetelDTO.getRletTpNm());
                    existingOfficetel.setTradTpNm(officetelDTO.getTradTpNm());
                    existingOfficetel.setFlrInfo(officetelDTO.getFlrInfo());
                    existingOfficetel.setPrc(officetelDTO.getPrc());
                    existingOfficetel.setRentPrc(officetelDTO.getRentPrc());
                    existingOfficetel.setHanPrc(officetelDTO.getHanPrc());
                    existingOfficetel.setSpc1(officetelDTO.getSpc1());
                    existingOfficetel.setSpc2(officetelDTO.getSpc2());
                    existingOfficetel.setDirection(officetelDTO.getDirection());
                    existingOfficetel.setAtclCfmYmd(officetelDTO.getAtclCfmYmd());
                    existingOfficetel.setLat(officetelDTO.getLat());
                    existingOfficetel.setLng(officetelDTO.getLng());
                    existingOfficetel.setAtclFetrDesc(officetelDTO.getAtclFetrDesc());
                    existingOfficetel.setTagList(officetelDTO.getTagList());
                    existingOfficetel.setBildNm(officetelDTO.getBildNm());
                    existingOfficetel.setTown(officetelDTO.getTown());
                    existingOfficetel.setRoadAddress(officetelDTO.getRoadAddress());
                    existingOfficetel.setAddress(officetelDTO.getAddress());
                    return officetelRepository.save(existingOfficetel);
                })
                .map(officetelMapper::toDTO)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Officetel not found")));
    }

    @Override
    public Mono<Void> deleteOfficetel(String id) {
        return officetelRepository.deleteById(id)
                .onErrorResume(e -> Mono.error(new IllegalArgumentException("Failed to delete officetel", e)));
    }
}