package org.afetankanet.socialmediamicroservice.controller;

import org.afetankanet.socialmediamicroservice.entity.ContentEntity;
import org.afetankanet.socialmediamicroservice.model.ContentDTO;
import org.afetankanet.socialmediamicroservice.model.UserLikeDislikeRequestModel;
import org.afetankanet.socialmediamicroservice.service.ContentSearchService;
import org.afetankanet.socialmediamicroservice.service.ContentService;
import org.afetankanet.socialmediamicroservice.service.LikeDislikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/contents")
public class ContentController {
    private final ContentService contentService;

    private final ContentSearchService contentSearchService;

    private final LikeDislikeService likeDislikeService;

    @Autowired
    public ContentController(ContentService contentService, ContentSearchService contentSearchService, LikeDislikeService likeDislikeService) {
        this.contentService = contentService;
        this.contentSearchService = contentSearchService;
        this.likeDislikeService = likeDislikeService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<ContentEntity>> search(@RequestParam String text) {
        return ResponseEntity.ok(contentSearchService.searchByText(text));
    }

    @PostMapping
    public ResponseEntity<ContentEntity> createContent(@RequestBody ContentEntity contentEntity) {
        return ResponseEntity.ok(contentService.saveContent(contentEntity));
    }

    @GetMapping
    public ResponseEntity<List<ContentDTO>> getAllContents() {
        return ResponseEntity.ok(contentService.findAllContents());
    }

    @GetMapping("/paging")
    public ResponseEntity<Page<ContentEntity>> getAllContentsWithPaging(@RequestParam(defaultValue = "0") int page,
                                                                      @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(contentService.findAllContentsWithPaging(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContentEntity> getContentById(@PathVariable Long id) {
        Optional<ContentEntity> tweet = contentService.findContentById(id);
        return tweet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContent(@PathVariable Long id) {
        contentService.deleteContent(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/like")
    public ResponseEntity<?> addLike(@RequestBody UserLikeDislikeRequestModel request) {
        try {
            likeDislikeService.addLike(request);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/dislike")
    public ResponseEntity<?> addDislike(@RequestBody UserLikeDislikeRequestModel request) {
        try {
            likeDislikeService.addDislike(request);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }


}
