package com.bangez.api.article.model;


import com.bangez.api.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity(name = "article")
public class Article {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String postTitle;
    private String postContent;
    private LocalDate postDate;
    private Long boardType; // 이 필드의 존재 이유는?.. 어차피 게시판은 구합니다 하나 아닌지?

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = true)
//    private User writer;
}
