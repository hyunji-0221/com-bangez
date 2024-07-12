package com.bangez.analysis.city_park.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("cityParks")
public class CityPark {
    @Id
    private String cityParkId ;

}
