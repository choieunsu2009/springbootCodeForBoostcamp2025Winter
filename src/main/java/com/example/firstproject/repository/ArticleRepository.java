package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    @Override
    @NullMarked
    ArrayList<Article> findAll();
}
