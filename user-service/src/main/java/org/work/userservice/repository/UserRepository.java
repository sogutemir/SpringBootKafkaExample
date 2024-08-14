package org.work.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.work.userservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}