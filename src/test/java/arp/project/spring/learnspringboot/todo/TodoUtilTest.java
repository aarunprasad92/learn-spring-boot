package arp.project.spring.learnspringboot.todo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TodoUtilTest {

    @Test
    void test() {
        Todo todo = new Todo(1, "arun", "Learn AWS", LocalDate.now(), false);
        List<Todo> todoList = new ArrayList<>();
        todoList.add(todo);

        TodoRepository todoRepositoryMock = mock(TodoRepository.class);
        when(todoRepositoryMock.findByUsername("arun")).thenReturn(todoList);
        TodoUtil todoUtil = new TodoUtil(todoRepositoryMock);
        assertEquals(1, todoUtil.findTodoCountForAnUser("arun"));
    }
}