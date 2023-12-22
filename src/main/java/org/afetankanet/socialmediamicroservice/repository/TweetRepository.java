package org.afetankanet.socialmediamicroservice.repository;

import org.afetankanet.socialmediamicroservice.entity.TweetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<TweetEntity, Long> {

}