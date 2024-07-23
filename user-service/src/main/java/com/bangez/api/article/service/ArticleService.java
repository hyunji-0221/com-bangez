package com.bangez.api.article.service;

import com.bangez.api.article.domain.Article;
import com.bangez.api.article.domain.ArticleDTO;
import com.bangez.api.common.MessengerVO;

import java.util.List;

public interface ArticleService {
    MessengerVO save(ArticleDTO articleDTO);
    MessengerVO deleteById(Long id);
    List<ArticleDTO> findAll();
    Article modify(Long id, Article newArticle);


    default ArticleDTO entityToDTO(Article article){
        return ArticleDTO.builder()
                .id(article.getId())
                .boardHits(article.getBoardHits())
                .postType(article.getPostType())
                .postContent(article.getPostContent())
                .postDate(article.getPostDate())
                .postTitle(article.getPostTitle())
                .build();
    }

    default Article dtoToEntity(ArticleDTO dto){
        return Article.builder()
                .id(dto.getId())
                .boardHits(dto.getBoardHits())
                .postType(dto.getPostType())
                .postContent(dto.getPostContent())
                .postTitle(dto.getPostTitle())
                .build();
    }

}