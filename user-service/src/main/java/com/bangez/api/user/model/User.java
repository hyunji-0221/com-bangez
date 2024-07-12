package com.bangez.api.user.model;

import com.bangez.api.article.model.Article;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity(name = "User")
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

    @Builder
    public User(Long id, String userName, String password, String passwordConfirm,
                String name, Long phone, String email){
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}
