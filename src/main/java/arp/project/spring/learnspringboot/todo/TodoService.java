package arp.project.spring.learnspringboot.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class TodoService {
    private static List<Todo> todoList = new ArrayList<>();

    private static int todosCount = 0;
    static {
        todoList.add(new Todo(++todosCount, "arun", "Learn AWS", LocalDate.now().plusMonths(3), false));
        todoList.add(new Todo(++todosCount, "arun", "Learn Docker", LocalDate.now().plusMonths(4), false));
        todoList.add(new Todo(++todosCount, "arun", "Learn Postgres", LocalDate.now().plusMonths(5), false));
    }

    public List<Todo> findByUsername(String username) {
        return todoList;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, done);
        todoList.add(todo);
    }
}
