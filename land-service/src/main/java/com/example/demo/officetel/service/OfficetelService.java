package com.example.demo.officetel.service;



import com.example.demo.officetel.domain.OfficetelDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OfficetelService {
    Flux<OfficetelDTO> getAllOfficetels();
    Mono<OfficetelDTO> getOfficetelById(String id);
    Mono<OfficetelDTO> createOfficetel(OfficetelDTO officetelDTO);
    Mono<OfficetelDTO> updateOfficetel(String id, OfficetelDTO officetelDTO);
    Mono<Void> deleteOfficetel(String id);
}