package com.bangez.analysis.apt_rent.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("aptRents")
public class AptRent {
    @Id
    private String aptRentId ;

}
