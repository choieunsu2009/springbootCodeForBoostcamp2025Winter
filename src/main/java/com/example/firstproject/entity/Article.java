package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@ToString
@Getter
public class Article {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    public Article() {
    }

    public void patch(Article article) {
        if (article.title != null) this.title = article.title;
        if (article.content != null) this.content = article.content;
    }
}
