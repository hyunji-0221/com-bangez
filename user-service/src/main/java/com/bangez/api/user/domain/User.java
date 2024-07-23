package com.bangez.api.user.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@Entity(name = "User")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String passwordConfirm;
    private String name;
    private Long phone;
    private String email;

//    @OneToMany(mappedBy = "writer", cascade = CascadeType.REMOVE)
//    private List<Article> article;

}
