package arp.project.spring.learnspringboot.todo;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoService {
    private TodoRepository todoRepository;
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findByUsername(String username) {
        return todoRepository.findByUsername(username);
    }

    public void addTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public void deleteTodoById(int id) {
        todoRepository.deleteById(id);
    }

    public Todo findById(int id) {
        return todoRepository.findById(id).get();
    }

    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }
}
