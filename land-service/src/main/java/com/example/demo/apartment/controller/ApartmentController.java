package com.example.demo.apartment.controller;

import com.example.demo.apartment.domain.ApartmentDTO;
import com.example.demo.apartment.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/apartments")
public class ApartmentController {


    private final ApartmentService apartmentService;

    @GetMapping
    public Flux<ApartmentDTO> getAllApartments() {
        return apartmentService.getAllApartments();
    }

    @GetMapping("/{id}")
    public Mono<ApartmentDTO> getApartmentById(@PathVariable String id) {
        return apartmentService.getApartmentById(id);
    }

    @PostMapping
    public Mono<ApartmentDTO> createApartment(@RequestBody ApartmentDTO apartmentDTO) {
        return apartmentService.createApartment(apartmentDTO);
    }

    @PutMapping("/{id}")
    public Mono<ApartmentDTO> updateApartment(@PathVariable String id, @RequestBody ApartmentDTO apartmentDTO) {
        return apartmentService.updateApartment(id, apartmentDTO);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteApartment(@PathVariable String id) {
        return apartmentService.deleteApartment(id);
    }

    @GetMapping("/search")
    public Flux<ApartmentDTO> searchApartments(@RequestParam String tradTpNm, @RequestParam int minPrice, @RequestParam int maxPrice) {
        return apartmentService.searchApartments(tradTpNm, minPrice, maxPrice);
    }

    @GetMapping("/searchByPrice")
    public Flux<ApartmentDTO> searchApartmentsByPrice(@RequestParam int minPrice, @RequestParam int maxPrice) {
        return apartmentService.searchApartmentsByPrice(minPrice, maxPrice);
    }


}








