package com.example.studentproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentProjectApplicationTests {

    Calculator testedCalculator = new Calculator();


    @Test
    void itShouldAddNumbers() {

        //given
        int a = 20;
        int b = 30;

        //when
        int result = testedCalculator.add(a,b);

        //then
        int expected = 50;
        assertEquals(expected,result);

    }


    @Test
    void contextLoads() {
    }

    class Calculator{
        int add (int  a, int b){
            return a+ b;
        }
    }
}
