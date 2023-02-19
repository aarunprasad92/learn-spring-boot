package arp.project.spring.learnspringboot.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class TodoService {
    private static List<Todo> todoList = new ArrayList<>();

    static {
        todoList.add(new Todo(1, "arun", "Learn AWS", LocalDate.now().plusMonths(3), false));
        todoList.add(new Todo(2, "arun", "Learn Docker", LocalDate.now().plusMonths(4), false));
        todoList.add(new Todo(3, "arun", "Learn Postgres", LocalDate.now().plusMonths(5), false));
    }

    public List<Todo> findByUsername(String username) {
        return todoList;
    }
}
