package com.liliapaper.tests;

import org.junit.jupiter.api.Test;

public class BaseJavaTest {



    @Test
    public void baseTest() {
        int a = 10;
        int b = 2;
        int cc = a+b;
        int bb = a*b;
        int dd = a%b;
        Double doub = 1.9;
        Double someSum = doub+a;
        System.out.println("Sum a+b = "+cc);
        System.out.println("Multiply a by b = "+bb);
        System.out.println("Integer division = "+dd);
        System.out.println("Sum double and int = "+someSum);
        a = 10;
        b = (a == 1) ? 20 : 30;
        System.out.println(b);

        b = (a == 10) ? 20 : 30;
        System.out.println(b);

        //переполнение
        int ax = Integer.MAX_VALUE;
        int bx = 5000;
        System.out.println(ax+bx);
    }
}
