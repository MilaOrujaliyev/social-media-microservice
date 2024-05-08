package org.afetankanet.socialmediamicroservice.repository.jpa;

import org.afetankanet.socialmediamicroservice.entity.CommentToSocialMediaContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentToSocialMediaContent, Long> {
}
