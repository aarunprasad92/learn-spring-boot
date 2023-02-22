package arp.project.spring.learnspringboot.todo;

import java.util.List;

public class TodoUtil {
    private TodoRepository todoRepository;
    public TodoUtil(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public int findTodoCountForAnUser(String username) {
        List<Todo> todoList = todoRepository.findByUsername(username);
        return todoList.size();
    }
}
