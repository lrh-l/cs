package com.lrh.cs.test;


import javax.servlet.http.HttpServlet;
import javax.swing.text.Style;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2  {
    public static void main(String[] args) {

    List list = new ArrayList(5);
        for (int i=0;i<9;i++){
            list.add(i);
        }
        Collections.swap(list,1,5);
        for (Object s:list){
            System.out.println((int)s);
        }
        System.out.println(Collections.max(list)+"----");

    }
}
