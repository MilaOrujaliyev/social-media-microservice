package org.afetankanet.socialmediamicroservice.repository.elasticsearch;
import org.springframework.data.elasticsearch.annotations.Query;

import org.afetankanet.socialmediamicroservice.entity.ContentEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ContentSearchRepository extends ElasticsearchRepository<ContentEntity, Long> {
    @Query("{\"match\": {\"text\": {\"query\": \"?0\", \"operator\": \"and\"}}}")
    List<ContentEntity> findByTextContaining(String text);

}
