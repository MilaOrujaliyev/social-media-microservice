package org.afetankanet.socialmediamicroservice.repository.jpa;

import org.afetankanet.socialmediamicroservice.entity.ContentEntity;
import org.afetankanet.socialmediamicroservice.entity.User;
import org.afetankanet.socialmediamicroservice.entity.UserLikeDislike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLikeDislikeRepository extends JpaRepository<UserLikeDislike, Long> {
    Optional<UserLikeDislike> findByUserAndContent(User user, ContentEntity content);
}
