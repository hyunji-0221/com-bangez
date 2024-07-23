package com.bangez.api.article.controller;

import com.bangez.api.article.domain.Article;
import com.bangez.api.article.domain.ArticleDTO;
import com.bangez.api.article.service.ArticleService;
import com.bangez.api.common.MessengerVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/article")
@RequiredArgsConstructor
@Slf4j
public class ArticleController {

    private final ArticleService service;

    @PostMapping("/save")
    public ResponseEntity<MessengerVO> save(@RequestBody ArticleDTO dto) {
        log.info("입력받은 정보 : {}", dto);
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<MessengerVO> deleteById(@RequestParam Long id)  {
        log.info("입력받은 정보 : {}", id );
        return ResponseEntity.ok(service.deleteById(id));
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<ArticleDTO>> findAll( ) {
        return ResponseEntity.ok(service.findAll());
    }

    @PatchMapping(path = "/update/{id}")
    public ResponseEntity<Article> modify(@PathVariable Long id, @RequestBody Article newArticle){
        log.info("입력받은 정보 : {}",newArticle);
        return ResponseEntity.ok(service.modify(id, newArticle));
    }


}