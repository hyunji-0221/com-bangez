package com.example.demo.apartment.domain;

import lombok.*;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "apartments")
public class ApartmentModel {

    @Id
    private String id;
    private long atclNo ;
    private String atclNm;
    private String rletTpNm;
    private String tradTpNm;
    private String flrInfo;
    private int prc;
    private long rentPrc;
    private String hanPrc;
    private double spc1;
    private double spc2;
    private String direction;
    private String atclCfmYmd; //date?
    private String lat;
    private String lng;
    private String atclFetrDesc;
    private List<String> tagList;
    private String bildNm;
    private String town;
    private String roadAddress;
    private String address;
}