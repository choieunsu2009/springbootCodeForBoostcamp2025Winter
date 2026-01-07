package com.example.firstproject.api;

import com.example.firstproject.dto.CommentForm;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class CommentApiController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/articles/{articleId}/comments")
    public Iterable<Comment> showCommentByArticle(@PathVariable Long articleId){
        // .orElse 대체할 놈으로 삼항연산자 사용했음
//        Iterable<Comment> commentEntity = (commentRepository.findByArticleId(articleId) != null) ? commentRepository.findByArticleId(articleId) : null;
//        model.addAttribute("comments", commentEntity);
//        return "comments/commentListByArticle";
        // @RestConntroller 사용으로 CommentService로 코드 분리
        return commentService.getCommentByArticleId(articleId);
    }

    @PostMapping("/articles/{articleId}/comments")
    public ResponseEntity<Comment> createComment(@PathVariable Long articleId, @RequestBody CommentForm dto){
        Comment created = commentService.createCommentByArticleId(dto, articleId);
        return (created != null) ? ResponseEntity.status(HttpStatus.OK).body(created) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/articles/comments/{id}")
    public String editComment(@PathVariable Long id, @RequestBody CommentForm dto){
        Comment editedCmt = commentService.editCommentByCommentId(id, dto);
        log.info(editedCmt.toString());
        return (editedCmt != null) ? "OK" : "NO";
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Comment> deleteComment(@PathVariable Long id) {
        Comment delCmt = commentService.delete(id);
        return (delCmt != null) ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
