package com.lrh.cs.test;

public class Test7 {
    private  static Test7 test7 ;
    private Test7(){}
    public static synchronized Test7 getTest7(){
        if (test7 == null) {
            test7 = new Test7();
        }
        return test7;
    }

}
