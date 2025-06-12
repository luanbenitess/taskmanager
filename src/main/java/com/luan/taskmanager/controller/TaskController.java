package com.luan.taskmanager.controller;

import com.luan.taskmanager.dto.TaskDTO;
import com.luan.taskmanager.response.GenericResponse;
import com.luan.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<GenericResponse<TaskDTO>> createTask(@Valid @RequestBody TaskDTO taskDTO) {
        TaskDTO createdTask = taskService.createTask(taskDTO);
        GenericResponse<TaskDTO> response = new GenericResponse<>(201, "Tarefa criada com sucesso", createdTask);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public ResponseEntity<GenericResponse<List<TaskDTO>>> getAllTasks() {
        List<TaskDTO> tasks = taskService.getAllTasks();
        GenericResponse<List<TaskDTO>> response = new GenericResponse<>(200, "Lista de tarefas retornada com sucesso",
                tasks);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<TaskDTO>> getTaskById(@PathVariable Long id) {
        TaskDTO task = taskService.getTaskById(id);
        GenericResponse<TaskDTO> response = new GenericResponse<>(200, "Tarefa retornada com sucesso", task);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<TaskDTO>> updateTask(@PathVariable Long id,
            @Valid @RequestBody TaskDTO taskDTO) {
        TaskDTO updatedTask = taskService.updateTask(id, taskDTO);
        GenericResponse<TaskDTO> response = new GenericResponse<>(200, "Tarefa atualizada com sucesso", updatedTask);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<Void>> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        GenericResponse<Void> response = new GenericResponse<>(200, "Tarefa deletada com sucesso", null);
        return ResponseEntity.ok(response);
    }
}
