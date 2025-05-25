package com.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import com.model.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class TodoService {

    public String addTodo(Todo todo) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("todos").document();
        todo.setId(docRef.getId());
        ApiFuture<WriteResult> result = docRef.set(todo);
        return docRef.getId();
    }

    public List<Todo> getTodosByUser(String userId) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        List<Todo> todos = new ArrayList<>();
        ApiFuture<QuerySnapshot> query = db.collection("todos").whereEqualTo("userId", userId).get();
        for (DocumentSnapshot doc : query.get().getDocuments()) {
            todos.add(doc.toObject(Todo.class));
        }
        return todos;
    }

    public Todo getTodoById(String id) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("todos").document(id);
        DocumentSnapshot snapshot = docRef.get().get();
        if (snapshot.exists()) {
            return snapshot.toObject(Todo.class);
        }
        return null;
    }

    public void updateTodo(String id, Todo todo) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        todo.setId(id);
        db.collection("todos").document(id).set(todo).get();
    }

    public void deleteTodo(String id) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        db.collection("todos").document(id).delete().get();
    }
}