package org.afetankanet.socialmediamicroservice.repository.jpa;


import org.afetankanet.socialmediamicroservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
