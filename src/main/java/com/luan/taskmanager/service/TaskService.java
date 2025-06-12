package com.luan.taskmanager.service;

import com.luan.taskmanager.dto.TaskDTO;
import com.luan.taskmanager.model.Task;
import com.luan.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Criar tarefa
    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = mapToEntity(taskDTO);
        Task savedTask = taskRepository.save(task);
        return mapToDTO(savedTask);
    }

    // Listar tarefas
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Buscar tarefa por ID
    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada com id " + id));
        return mapToDTO(task);
    }

    // Atualizar tarefa
    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada com id " + id));

        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setCompleted(taskDTO.isCompleted());

        Task updatedTask = taskRepository.save(task);
        return mapToDTO(updatedTask);
    }

    // Deletar tarefa
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task não encontrada com id " + id);
        }
        taskRepository.deleteById(id);
    }

    // Conversor de Entity -> DTO
    private TaskDTO mapToDTO(Task task) {
        return new TaskDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted()
        );
    }

    // Conversor de DTO -> Entity
    private Task mapToEntity(TaskDTO taskDTO) {
        return new Task(
                taskDTO.getTitle(),
                taskDTO.getDescription(),
                taskDTO.isCompleted()
        );
    }
}
