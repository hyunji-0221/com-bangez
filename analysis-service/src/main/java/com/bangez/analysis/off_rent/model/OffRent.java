package com.bangez.analysis.off_rent.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("offRents")
public class OffRent {
    @Id
    private String offRentId ;

}
