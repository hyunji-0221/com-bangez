package com.example.demo;


import com.example.demo.common.config.CustomException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FluxAndMonoTest {

    @Mock
    CustomException customExceptionMono;

    @Mock
    CustomException customExceptionFlux;

    @BeforeEach
    void setUp() {
        customExceptionMono = new CustomException("Mono");
        customExceptionFlux = new CustomException("Flux");
    }

//    @Test
//    @DisplayName("Flux just() sample")
//    void justTest() {
//        List<String> names = new ArrayList<>();
//        Flux<String> flux = Flux.just("김구", "윤봉길", "유관순").log();
//        flux.subscribe(names::add);
//        assertThat(names).isEqualTo(Arrays.asList("김구", "윤봉길", "유관순"));
//    }

    @Test
    @DisplayName("Flux create() sample")
    void FluxCreateTest() {

        Flux<Integer> flux = Flux.create((FluxSink<Integer> sink) -> {
            sink.onRequest(request -> {
                for (int i = 0; i < request + 3; i++) {
                    sink.next(i);
                }
            });
        });
        flux.take(3).next();
        flux.subscribe(System.out::println);
    }

    @Test
    @DisplayName("Flux create() sample")
    void FluxGeneratorTest() {
        Flux<String> flux = Flux.generate(() -> {
                    return 0;
                },
                (state, sink) -> {
                    sink.next("3 * " + state + " = " + state);
                    if (state == 10) {
                        sink.complete();
                    }
                    return state + 1;
                });
        flux.subscribe(System.out::println);
    }
}

