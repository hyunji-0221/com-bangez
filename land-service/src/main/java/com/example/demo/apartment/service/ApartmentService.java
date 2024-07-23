package com.example.demo.apartment.service;

import com.example.demo.apartment.domain.ApartmentDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ApartmentService {
    Flux<ApartmentDTO> getAllApartments();
    Mono<ApartmentDTO> getApartmentById(String id);
    Mono<ApartmentDTO> createApartment(ApartmentDTO apartmentDTO);
    Mono<ApartmentDTO> updateApartment(String id, ApartmentDTO apartmentDTO);
    Mono<Void> deleteApartment(String id);
    Flux<ApartmentDTO> searchApartments(String tradTpNm, int minPrice, int maxPrice);
    Flux<ApartmentDTO> searchApartmentsByPrice(int minPrice, int maxPrice);
}