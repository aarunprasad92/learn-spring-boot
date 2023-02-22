package arp.project.spring.learnspringboot;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class ListTest {
    @Test
    void simpleTest() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(10);

        assertEquals(10, listMock.size());
        assertEquals(10, listMock.size());
    }

    @Test
    void multipleReturns() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(10).thenReturn(12);

        assertEquals(10, listMock.size());
        assertEquals(12, listMock.size());
        assertEquals(12, listMock.size());

    }

    @Test
    void specificParameters() {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("some string");

        assertEquals("some string", listMock.get(0));
        assertEquals(null, listMock.get(1));
    }

    @Test
    void genericParameters() {
        List listMock = mock(List.class);
        when(listMock.get(Mockito.anyInt())).thenReturn("some string");

        assertEquals("some string", listMock.get(0));
        assertEquals("some string", listMock.get(1));
    }
}
