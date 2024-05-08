package org.afetankanet.socialmediamicroservice.service;

import org.afetankanet.socialmediamicroservice.converter.ContentConverterDTO;
import org.afetankanet.socialmediamicroservice.entity.ContentEntity;
import org.afetankanet.socialmediamicroservice.model.ContentDTO;
import org.afetankanet.socialmediamicroservice.repository.jpa.ContentRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContentService {
    private final ContentRepository contentRepository;

    @Autowired
    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @CacheEvict(value = "contents", allEntries = true)
    public ContentEntity saveContent(ContentEntity contentEntity) {
        try {
            return contentRepository.save(contentEntity);
        } catch (ConstraintViolationException | DataIntegrityViolationException e) {
            System.out.println("ConstraintViolationException : The content is already exist ");
            return null;
        }

    }

    @CacheEvict(value = "contents", allEntries = true)
    public boolean evictContent() {

        try {
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Cacheable(value = "contents")
    public List<ContentDTO> findAllContents() {
        List<ContentEntity> contentEntities = contentRepository.findAll(Sort.by("tweetId").descending());
        return contentEntities.stream()
                .map(ContentConverterDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    public Page<ContentEntity> findAllContentsWithPaging(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("tweetId").descending());
        return contentRepository.findAll(pageable);
    }

    public Optional<ContentEntity> findContentById(Long id) {
        return contentRepository.findById(id);
    }

    public void deleteContent(Long id) {
        contentRepository.deleteById(id);
    }
}
