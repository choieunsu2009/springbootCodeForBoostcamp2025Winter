package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
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

    @Autowired
    ArticleRepository articleRepository;

    @Test
    void index() {

        // 수정 코드
        Article a = articleRepository.save(new Article(null, "111", "111"));
        Article b = articleRepository.save(new Article(null, "222", "222"));
        Article c = articleRepository.save(new Article(null, "333", "333"));

        // 에러
//        Article a = new Article(1L, "111", "1111");
//        Article b = new Article(2L, "222", "2222");
//        Article c = new Article(3L, "333", "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));

        List<Article> article = articleService.index();

        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show_fail() {
        Long id = -1L;
        Article expected = null;

        Article article = articleService.show(id);

        assertEquals(expected, article);
    }

    @Test
    void create_success() {
        String title = "444";
        String content = "444";
        ArticleForm dto= new ArticleForm(null, title, content);

        Article expected = new Article(4L, title, content);

        Article article = articleService.create(dto);

        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void create_fail() {
        Long id = 4L;
        String title = "444";
        String content = "444";

        ArticleForm dto= new ArticleForm(id, title, content);

        Article expected = null;

        Article article = articleService.create(dto);

        assertEquals(expected, article);
    }
}