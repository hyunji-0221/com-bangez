package com.bangez.analysis.school.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("school")
public class School {
    @Id
    private String schoolId ;
    private String sidoGyoyukCheongCode;  // 시도교육청코드
    private String sidoGyoyukCheongName;  // 시도교육청명
    private int administrativeStandardCode;  // 행정표준코드
    private String schoolName;  // 학교명
    private String englishSchoolName;  // 영문학교명
    private String schoolTypeName;  // 학교종류명
    private String sidoName;  // 시도명
    private String jurisdictionName;  // 관할조직명
    private String establishmentName;  // 설립명
    private int roadPostalCode;  // 도로명우편번호
    private String roadAddress;  // 도로명주소
    private String roadDetailAddress;  // 도로명상세주소
    private String phoneNumber;  // 전화번호
    private String homepageAddress;  // 홈페이지주소
    private String coeducationDivisionName;  // 남녀공학구분명
    private String faxNumber;  // 팩스번호
    private String highSchoolDivisionName;  // 고등학교구분명
    private String specialIndustrialClassExistence;  // 산업체특별학급존재여부
    private String highSchoolGeneralProfessionalDivisionName;  // 고등학교일반전문구분명
    private String specialPurposeHighSchoolAffiliationName;  // 특수목적고등학교계열명
    private String entranceAfterGraduationDivisionName;  // 입시전후기구분명
    private String dayNightDivisionName;  // 주야구분명
    private int establishmentDate;  // 설립일자
    private int foundingAnniversary;  // 개교기념일
    private int modificationDate;  // 수정일자

}
