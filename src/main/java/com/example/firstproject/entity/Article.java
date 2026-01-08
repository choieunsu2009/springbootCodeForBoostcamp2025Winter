package com.example.firstproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@ToString
@Getter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @OneToMany(mappedBy = "article", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @ToString.Exclude
    @JsonIgnore
    private List<Comment> comments = new ArrayList<>();

    public Article() {
    }


    public Article(Long id, String title, String  content){
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public void patch(Article article) {
        if (article.title != null) this.title = article.title;
        if (article.content != null) this.content = article.content;
    }
}
