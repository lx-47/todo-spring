package com.example.todo.dto;

public class TodoRequest {
    private String Title;
    private String Description;

    // Getters
    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    // Setters
    public void setTitle(String title) {
        this.Title = title;
    }

    public void setDescription(String description) {
        this.Description = description;
    }
}
