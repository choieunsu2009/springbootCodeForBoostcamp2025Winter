package com.example.firstproject.service;

import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleApiServiceTest {
    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        Article a = new Article(1L, "111", "1111");
        Article b = new Article(2L, "222", "2222");
        Article c = new Article(3L, "333", "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));

        List<Article> article = articleService.index();

        assertEquals(expected.toString(), article.toString());
    }
}