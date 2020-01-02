package com.lrh.cs.test;

import java.util.List;

public  interface Test5 {
     void test( int a);

    default void demo(int a){
        System.out.println(a);
    };
}
