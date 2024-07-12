package com.bangez.apigateway.config;

import com.bangez.apigateway.filter.AuthorizationHeaderFilter;
import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FilterConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder, AuthorizationHeaderFilter headerFilter) {
        return builder.routes()
                .route(r -> r.path("/tx-service/**")
                        .filters(f -> f.addRequestHeader("tx-request", "tx-request-header")
                                .addResponseHeader("tx-response", "tx-response-header")
                        .filter(headerFilter.apply(new AuthorizationHeaderFilter.Config())))
                        .uri("http://localhost:8081"))

                .route(r -> r.path("/user-service/**")
                        .filters(f -> f.addRequestHeader("user-request", "user-request-header")
                                .addResponseHeader("user-response", "user-response-header")
                        .filter(headerFilter.apply(new AuthorizationHeaderFilter.Config())))
                        .uri("http://localhost:8082"))

                .route(r -> r.path("/land-service/**")
                        .filters(f -> f.addRequestHeader("land-request", "land-request-header")
                                .addResponseHeader("land-response", "land-response-header")
                        .filter(headerFilter.apply(new AuthorizationHeaderFilter.Config())))
                        .uri("http://localhost:8083"))

                .route(r -> r.path("/analysis-service/**")
                        .filters(f -> f.addRequestHeader("analysis-request", "analysis-request-header")
                                .addResponseHeader("analysis-response", "analysis-response-header")
                        .filter(headerFilter.apply(new AuthorizationHeaderFilter.Config())))
                        .uri("http://localhost:8084"))

                .route(r -> r.path("/chat-service/**")
                        .filters(f -> f.addRequestHeader("chat-request", "chat-request-header")
                                .addResponseHeader("chat-response", "chat-response-header")
                                .filter(headerFilter.apply(new AuthorizationHeaderFilter.Config())))
                        .uri("http://localhost:8085"))

                .build();
    }

}
