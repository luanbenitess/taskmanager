package com.luan.taskmanager.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.luan.taskmanager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}