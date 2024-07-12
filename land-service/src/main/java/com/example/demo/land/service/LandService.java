package com.example.demo.land.service;


import com.example.demo.land.domain.LandDTO;
import com.example.demo.land.domain.LandModel;
import com.example.demo.land.repository.LandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LandService {

    @Autowired
    private LandRepository landRepository;

    public Flux<LandDTO> getAllLands() {
        return landRepository.findAll().map(this::toDTO);
    }

    public Mono<LandDTO> getLandById(String id) {
        return landRepository.findById(id).map(this::toDTO);
    }

    public Mono<LandDTO> createLand(LandDTO landDTO) {
        return landRepository.save(toModel(landDTO)).map(this::toDTO);
    }

    public Mono<LandDTO> updateLand(String id, LandDTO landDTO) {
        return landRepository.findById(id)
                .flatMap(existingLand -> {
                    existingLand.setAtclNm(landDTO.getAtclNm());
//                    existingLand.setLocation(landDTO.getLocation());
//                    existingLand.setPrice(landDTO.getPrice());
                    return landRepository.save(existingLand);
                })
                .map(this::toDTO);
    }

    public Mono<Void> deleteLand(String id) {
        return landRepository.deleteById(id);
    }

    private LandDTO toDTO(LandModel landModel) {
        LandDTO landDTO = new LandDTO();
        landDTO.setId(landModel.getId());
        landDTO.setAtclNm(landModel.getAtclNm());
//        landDTO.setLocation(landModel.getLocation());
//        landDTO.setPrice(landModel.getPrice());
        return landDTO;
    }

    private LandModel toModel(LandDTO landDTO) {
        LandModel landModel = new LandModel();
        landModel.setId(landDTO.getId());
        landModel.setAtclNm(landDTO.getAtclNm());
//        landModel.setLocation(landDTO.getLocation());
//        landModel.setPrice(landDTO.getPrice());
        return landModel;
    }
}