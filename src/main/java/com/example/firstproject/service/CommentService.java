package com.example.firstproject.service;

import com.example.firstproject.dto.CommentForm;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;


    public Iterable<Comment> getCommentByArticleId(Long articleId) {
        Iterable<Comment> commentEntity = (commentRepository.findByArticleId(articleId) != null) ? commentRepository.findByArticleId(articleId) : null;
        return commentEntity;
    }

    public Comment createCommentByArticleId(CommentForm dto, Long id) {
        Comment comment = dto.toEntity();
        if(comment.getId() != null) return null;
        if(comment.getArticle().getId() != id) return null;
        return commentRepository.save(comment);
    }

    public Comment editCommentByCommentId(Long id, CommentForm dto) {
        Comment comment = dto.toEntity();

        Comment target = commentRepository.findById(id).orElse(null);

        if (target == null || id != comment.getId()) { return null; }

        target.patch(comment);
        Comment updated = commentRepository.save(target);
        return updated;
    }

    public Comment delete(Long id) {
        Comment target = commentRepository.findById(id).orElse(null);
        if (target == null) return null;

        commentRepository.delete(target);
        return target;
    }
}
