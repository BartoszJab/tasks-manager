package com.example.tasksmanager.repository;

import com.example.tasksmanager.model.Group;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO group_user (group_id, user_id) VALUES (:groupId, :userId)", nativeQuery = true)
    void addUserToGroup(@Param("groupId") Long groupId, @Param("userId") Long userId);
}
