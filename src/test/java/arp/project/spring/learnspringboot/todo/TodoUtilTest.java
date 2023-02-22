package arp.project.spring.learnspringboot.todo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TodoUtilTest {

    @Mock
    private TodoRepository todoRepositoryMock;

    @InjectMocks
    private TodoUtil todoUtil;

    @Test
    void test() {
        Todo todo = new Todo(1, "arun", "Learn AWS", LocalDate.now(), false);
        List<Todo> todoList = new ArrayList<>();
        todoList.add(todo);

        when(todoRepositoryMock.findByUsername("arun")).thenReturn(todoList);
        assertEquals(1, todoUtil.findTodoCountForAnUser("arun"));
    }
}