package com.example.demo.officetel.controller;

import com.example.demo.officetel.service.OfficetelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.officetel.domain.OfficetelDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/officetels")
public class OfficetelController {

    private final OfficetelService officetelService;

    @Autowired
    public OfficetelController(OfficetelService officetelService) {
        this.officetelService = officetelService;
    }

    @GetMapping
    public Flux<OfficetelDTO> getAllOfficetels() {
        return officetelService.getAllOfficetels();
    }

    @GetMapping("/{id}")
    public Mono<OfficetelDTO> getOfficetelById(@PathVariable String id) {
        return officetelService.getOfficetelById(id);
    }

    @PostMapping
    public Mono<OfficetelDTO> createOfficetel(@RequestBody OfficetelDTO officetelDTO) {
        return officetelService.createOfficetel(officetelDTO);
    }

    @PutMapping("/{id}")
    public Mono<OfficetelDTO> updateOfficetel(@PathVariable String id, @RequestBody OfficetelDTO officetelDTO) {
        return officetelService.updateOfficetel(id, officetelDTO);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteOfficetel(@PathVariable String id) {
        return officetelService.deleteOfficetel(id);
    }
}