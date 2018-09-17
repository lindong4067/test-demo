package com.example.testdemo.mock;

import static org.mockito.Mockito.*;
import org.junit.Test;
import java.util.LinkedList;

public class MockTest {

    @Test
    public void test01(){
        LinkedList mockedList = mock(LinkedList.class);
        mockedList.add(1);
        mockedList.clear();
        verify(mockedList).add(1);
        verify(mockedList).clear();
    }
}
