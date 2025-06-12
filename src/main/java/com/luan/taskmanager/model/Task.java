package com.luan.taskmanager.model;

import jakarta.persistence.Entity; // Importa a anotação Entity do Jakarta Persistence
import jakarta.persistence.Id; // Importa a anotação Id do Jakarta Persistence
import jakarta.persistence.GeneratedValue; // Importa a anotação GeneratedValue do Jakarta Persistence
import jakarta.persistence.GenerationType; // Importa a anotação GenerationType do Jakarta Persistence

@Entity // Anotação que indica que esta classe é uma entidade JPA
public class Task {

    @Id // Anotação que indica que este campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotação que indica que o valor da chave primária será gerado
                                                        // automaticamente pelo banco de dados
    private Long id; // Campo que representa o ID da tarefa, do tipo Long

    private String title; // Campo que representa o título da tarefa, do tipo String
    private String description; // Campo que representa a descrição da tarefa, do tipo String
    private boolean completed; // Campo que indica se a tarefa está concluída, do tipo boolean

    public Task() {
        // Construtor padrão necessário para o JPA
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false; // Inicializa completed como false por padrão
    }

    public Long getId() {
        return id; // Retorna o ID da tarefa
    }

    public void setId(Long id) {
        this.id = id; // Define o ID da tarefa
    }

    public String getTitle() {
        return title; // Retorna o título da tarefa
    }

    public void setTitle(String title) {
        this.title = title; // Define o título da tarefa
    }

    public String getDescription() {
        return description; // Retorna a descrição da tarefa
    }

    public void setDescription(String description) {
        this.description = description; // Define a descrição da tarefa
    }

    public boolean isCompleted() {
        return completed; // Retorna se a tarefa está concluída
    }

    public void setCompleted(boolean completed) {
        this.completed = completed; // Define se a tarefa está concluída
    }

public Task(String title, String description, boolean completed) {
    this.title = title;
    this.description = description;
    this.completed = completed;
}
}