package com.controller;

import com.model.Todo;
import com.service.TodoService;
import com.todos.FirebaseAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private FirebaseAuthService firebaseAuthService;

    @PostMapping
    public ResponseEntity<String> createTodo(@RequestBody Todo todo,
                                             @RequestHeader("Authorization") String token) throws ExecutionException, InterruptedException {
        String userId = firebaseAuthService.verifyIdTokenAndGetUid(token);
        todo.setUserId(userId);
        todoService.addTodo(todo);
        return ResponseEntity.ok("Todo created");
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos(@RequestHeader("Authorization") String token) throws ExecutionException, InterruptedException {
        String userId = firebaseAuthService.verifyIdTokenAndGetUid(token);
        List<Todo> todos = todoService.getTodosByUser(userId);
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable String id,
                                        @RequestHeader("Authorization") String token) throws ExecutionException, InterruptedException {
        firebaseAuthService.verifyIdTokenAndGetUid(token); // Просто проверка токена, можно добавить проверку userId
        Todo todo = todoService.getTodoById(id);
        return todo != null ? ResponseEntity.ok(todo) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTodo(@PathVariable String id,
                                             @RequestBody Todo todo,
                                             @RequestHeader("Authorization") String token) throws ExecutionException, InterruptedException {
        firebaseAuthService.verifyIdTokenAndGetUid(token);
        todoService.updateTodo(id, todo);
        return ResponseEntity.ok("Todo updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable String id,
                                             @RequestHeader("Authorization") String token) throws ExecutionException, InterruptedException {
        firebaseAuthService.verifyIdTokenAndGetUid(token);
        todoService.deleteTodo(id);
        return ResponseEntity.ok("Todo deleted");
    }
}