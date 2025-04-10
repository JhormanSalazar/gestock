package com.gestock.gestock.persistence.repository;

import com.gestock.gestock.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByEmail(String email);
    boolean existsByEmail(String email);
}
