package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class CommentForm {
    private Long id;
    private Article article;
    private String nickname;
    private String body;

    public Comment toEntity() { return new Comment(id, article, nickname, body); }
}
