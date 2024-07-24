package com.bangez.analysis.apt_trade.controller;

import com.bangez.analysis.apt_rent.controller.AptRentRouter;
import com.bangez.analysis.apt_trade.service.AptTradeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Log4j2
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/apt_trade")
public class AptTradeController {

    private final AptTradeRouter router;

    @GetMapping(path = "/statistics")
    public ResponseEntity<?> searchPlayer(
            @RequestParam(value = "select", required = true) String select,
            @RequestParam(value = "date", required = false) String date
    ) {
        Mono<?> monoMap = router.execute(select, date);

        return ResponseEntity.ok(monoMap);
    }

}