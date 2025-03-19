package com.example.todo.service;

import com.example.todo.Mapper.TodoMapper;
import com.example.todo.dto.TodoRequest;
import com.example.todo.dto.TodoResponse;
import com.example.todo.entity.TodoEntity;
import com.example.todo.exception.TodoNotFoundException;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<TodoResponse> getAllTodos(){
        return todoRepository.findAll().stream().
                map(TodoMapper::todoResponse).
                collect(Collectors.toList());
    }

    public TodoResponse createTodo(TodoRequest todoRequest){
        TodoEntity todoEntity = new TodoEntity(
                todoRequest.getTitle(),
                todoRequest.getDescription()
        );
        TodoEntity savedTodo = todoRepository.save(todoEntity);
        return TodoMapper.todoResponse(savedTodo);
    }

    public TodoResponse updateTodo(Long id, TodoRequest todoRequest) {
        TodoEntity todoEntity = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found with id: " + id));

        todoEntity.setTitle(todoRequest.getTitle());
        todoEntity.setDescription(todoRequest.getDescription());
        TodoEntity updatedTodo = todoRepository.save(todoEntity);

        return TodoMapper.toTodoResponse(updatedTodo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
