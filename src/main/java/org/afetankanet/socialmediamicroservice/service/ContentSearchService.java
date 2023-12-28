package org.afetankanet.socialmediamicroservice.service;

import org.afetankanet.socialmediamicroservice.entity.ContentEntity;
import org.afetankanet.socialmediamicroservice.repository.elasticsearch.ContentSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentSearchService {

    private final ContentSearchRepository contentSearchRepository;

    @Autowired
    public ContentSearchService(ContentSearchRepository contentSearchRepository) {
        this.contentSearchRepository = contentSearchRepository;
    }

    public void save(ContentEntity contentEntity) {
        contentSearchRepository.save(contentEntity);
    }

    public List<ContentEntity> searchByText(String text) {
        return contentSearchRepository.findByTextContaining(text);
    }
}
