package org.afetankanet.socialmediamicroservice.controller;

import org.afetankanet.socialmediamicroservice.entity.CommentToSocialMediaContent;
import org.afetankanet.socialmediamicroservice.model.CommentRequestModel;
import org.afetankanet.socialmediamicroservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/commentsToSocialMediaContent")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @PostMapping("/save")
    public ResponseEntity<CommentToSocialMediaContent> createComment(@RequestBody CommentRequestModel commentRequestModel) {
        CommentToSocialMediaContent savedComment = commentService.saveComment(commentRequestModel);
        return ResponseEntity.ok(savedComment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id) {
        CommentToSocialMediaContent comment = commentService.getComment(id);
        if (comment == null) {
            return ResponseEntity.notFound().build();
        }
        commentService.deleteComment(id);
        return ResponseEntity.ok().build();
    }
}
