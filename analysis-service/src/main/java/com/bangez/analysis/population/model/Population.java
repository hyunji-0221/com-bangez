package com.bangez.analysis.population.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("population")
public class Population {
    @Id
    private String populationId ;

}
