package com.cafe_depot.cafe_depot.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cafe_depot.cafe_depot.entities.UserSessionEntity;

@Repository
public interface UserSessionRepository extends JpaRepository<UserSessionEntity, Long> {
    Optional <UserSessionEntity> getBySessionId(String sessionId);
}
