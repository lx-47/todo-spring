package com.example.todo.Mapper;


import com.example.todo.dto.TodoResponse;
import com.example.todo.entity.TodoEntity;

public class TodoMapper {
    public static TodoResponse todoResponse(TodoEntity todoEntity){
        return new TodoResponse(
                todoEntity.getId(),
                todoEntity.getTitle(),
                todoEntity.getDescription(),
                todoEntity.isCompleted(),
                todoEntity.getCreatedAt()
        );
    }
}
