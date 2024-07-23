package com.bangez.api.article.service.impl;

import com.bangez.api.article.domain.Article;
import com.bangez.api.article.domain.ArticleDTO;
import com.bangez.api.article.repository.ArticleRepository;
import com.bangez.api.article.service.ArticleService;
import com.bangez.api.common.MessengerVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository repository;


    @Override
    public MessengerVO save(ArticleDTO dto) {
        repository.save(dtoToEntity(dto));
        return MessengerVO.builder().message("성공").build();
    }

    @Override
    public MessengerVO deleteById(Long id) {
        repository.deleteById(id);
        return MessengerVO.builder().message("삭제 성공").build();
    }

    @Override
    public List<ArticleDTO> findAll() {
        return repository.findAll().stream().map(i->entityToDTO(i)).toList();
    }

    @Override
    public Article modify(Long id, Article newArticle) {
        return repository.findById(id).map(article -> {
            if (newArticle.getPostTitle() !=null){
                article.setPostTitle(newArticle.getPostTitle());
            }
            if (newArticle.getPostContent() !=null) {
                article.setPostContent(newArticle.getPostContent());
            }
            return repository.save(article);
        }).orElseThrow(()->new RuntimeException("게시글을 찾을 수 없음"));
    }
}