package com.example.todo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Title;
    private String Description;
    private Boolean Completed;
    private LocalDateTime CreatedAt;

    public  TodoEntity() {}

    public TodoEntity (String Title, String Description){
        this.Title = Title;
        this.Description = Description;
        this.Completed = false;
        this.CreatedAt = LocalDateTime.now();
    }
    // Getters
    public Long getId() {
        return Id;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public boolean isCompleted() {
        return Completed;
    }

    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }

    // Setters
    public void setId(Long id) {
        this.Id = id;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public void setCompleted(boolean completed) {
        this.Completed = completed;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.CreatedAt = createdAt;
    }
}
