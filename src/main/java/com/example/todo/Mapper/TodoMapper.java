package com.example.todo.Mapper;


import com.example.todo.dto.TodoResponse;
import com.example.todo.entity.TodoEntity;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {
    public TodoResponse todoResponse(TodoEntity todoEntity) {
        TodoResponse response = new TodoResponse();
        response.setId(todoEntity.getId());
        response.setTitle(todoEntity.getTitle());
        response.setDescription(todoEntity.getDescription());
        response.setCompleted(todoEntity.isCompleted());
        response.setCreatedAt(todoEntity.getCreatedAt());
        return response;
    }
}
