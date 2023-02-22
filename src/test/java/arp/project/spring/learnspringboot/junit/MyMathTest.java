package arp.project.spring.learnspringboot.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {

    @Test
    void calculateSum() {
        int[] numbers = {1, 2, 3};
        MyMath myMath = new MyMath();
        int result = myMath.calculateSum(numbers);
        int expectedResult = 6;
        assertEquals(expectedResult, result);
    }
}