package com.example.firstproject.service;

import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ArticleServiceTest {
    @Autowired
    ArticleService articleService;


    @Test
    void show_success() {
        // 예상 데이터
        Long id = 1L;
        Article expected = new Article(id, "111", "1111");

        // 실제 데이터
        Article article = articleService.show(id);

        // 비교 및 검증
        System.out.println(expected.toString());
        System.out.println(article.toString());
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show_fail(){

    }
}