package arp.project.spring.learnspringboot.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todoList = new ArrayList<>();

    private static int todosCount = 0;
    static {
        todoList.add(new Todo(++todosCount, "prasad", "Learn AWS", LocalDate.now().plusMonths(3), false));
        todoList.add(new Todo(++todosCount, "arun", "Learn Docker", LocalDate.now().plusMonths(4), false));
        todoList.add(new Todo(++todosCount, "arun", "Learn Postgres", LocalDate.now().plusMonths(5), false));
    }

    public List<Todo> findByUsername(String username) {
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todoList.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, done);
        todoList.add(todo);
    }

    public void deleteTodoById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todoList.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        return todoList.stream().filter(predicate).findFirst().get();
    }

    public void updateTodo(Todo todo) {
        deleteTodoById(todo.getId());
        todoList.add(todo);
    }
}
