package com.example.demo.land.controller;


import com.example.demo.land.domain.LandDTO;
import com.example.demo.land.service.LandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/lands")
public class LandController {

    @Autowired
    private LandService landService;

    @GetMapping
    public Flux<LandDTO> getAllLands() {
        return landService.getAllLands();
    }

    @GetMapping("/{id}")
    public Mono<LandDTO> getLandById(@PathVariable String id) {
        return landService.getLandById(id);
    }

    @PostMapping
    public Mono<LandDTO> createLand(@RequestBody LandDTO landDTO) {
        return landService.createLand(landDTO);
    }

    @PutMapping("/{id}")
    public Mono<LandDTO> updateLand(@PathVariable String id, @RequestBody LandDTO landDTO) {
        return landService.updateLand(id, landDTO);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteLand(@PathVariable String id) {
        return landService.deleteLand(id);
    }
}