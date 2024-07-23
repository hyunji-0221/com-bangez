package com.example.demo.apartment.service.impl;

import com.example.demo.apartment.domain.ApartmentDTO;
import com.example.demo.apartment.domain.ApartmentMapper;
import com.example.demo.apartment.domain.ApartmentModel;
import com.example.demo.apartment.repository.ApartmentRepository;
import com.example.demo.apartment.service.ApartmentService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private final ApartmentMapper apartmentMapper;
    private final ApartmentRepository apartmentRepository;

    public ApartmentServiceImpl(ApartmentMapper apartmentMapper, ApartmentRepository apartmentRepository) {
        this.apartmentMapper = apartmentMapper;
        this.apartmentRepository = apartmentRepository;
    }
    @Override
    public Flux<ApartmentDTO> getAllApartments() {
        return apartmentRepository.findAll()
                .map(apartmentMapper::toDTO);
    }
    @Override
    public Mono<ApartmentDTO> getApartmentById(String id) {
        return apartmentRepository.findById(id)
                .map(apartmentMapper::toDTO)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Apartment not found")));
    }
    @Override
    public Mono<ApartmentDTO> createApartment(ApartmentDTO apartmentDTO) {
        ApartmentModel model = apartmentMapper.toModel(apartmentDTO);
        return apartmentRepository.save(model)
                .map(apartmentMapper::toDTO);
    }
    @Override
    public Mono<ApartmentDTO> updateApartment(String id, ApartmentDTO apartmentDTO) {
        return apartmentRepository.findById(id)
                .flatMap(existingApartment -> {
                    existingApartment.setAtclNo(apartmentDTO.getAtclNo());
                    existingApartment.setAtclNm(apartmentDTO.getAtclNm());
                    existingApartment.setRletTpNm(apartmentDTO.getRletTpNm());
                    existingApartment.setTradTpNm(apartmentDTO.getTradTpNm());
                    existingApartment.setFlrInfo(apartmentDTO.getFlrInfo());
                    existingApartment.setPrc(apartmentDTO.getPrc());
                    existingApartment.setRentPrc(apartmentDTO.getRentPrc());
                    existingApartment.setHanPrc(apartmentDTO.getHanPrc());
                    existingApartment.setSpc1(apartmentDTO.getSpc1());
                    existingApartment.setSpc2(apartmentDTO.getSpc2());
                    existingApartment.setDirection(apartmentDTO.getDirection());
                    existingApartment.setAtclCfmYmd(apartmentDTO.getAtclCfmYmd());
                    existingApartment.setLat(apartmentDTO.getLat());
                    existingApartment.setLng(apartmentDTO.getLng());
                    existingApartment.setAtclFetrDesc(apartmentDTO.getAtclFetrDesc());
                    existingApartment.setTagList(apartmentDTO.getTagList());
                    existingApartment.setBildNm(apartmentDTO.getBildNm());
                    existingApartment.setTown(apartmentDTO.getTown());
                    existingApartment.setRoadAddress(apartmentDTO.getRoadAddress());
                    existingApartment.setAddress(apartmentDTO.getAddress());
                    return apartmentRepository.save(existingApartment);
                })
                .map(apartmentMapper::toDTO)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Apartment not found")));
    }
    @Override
    public Mono<Void> deleteApartment(String id) {
        return apartmentRepository.deleteById(id)
                .onErrorResume(e -> Mono.error(new IllegalArgumentException("Failed to delete apartment", e)));
    }
    @Override
    public Flux<ApartmentDTO> searchApartments(String tradTpNm, int minPrice, int maxPrice) {
        return apartmentRepository.findByTradTpNmAndPrcBetween(tradTpNm, minPrice, maxPrice)
                .map(apartmentMapper::toDTO);
    }
    @Override
    public Flux<ApartmentDTO> searchApartmentsByPrice(int minPrice, int maxPrice) {
        return apartmentRepository.findByPrcBetween(minPrice, maxPrice)
                .map(apartmentMapper::toDTO);
    }
}