package org.afetankanet.socialmediamicroservice.repository;

import org.afetankanet.socialmediamicroservice.entity.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<ContentEntity, Long> {

}