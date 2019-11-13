package com.lrh.cs.utils;

public class test {
    public static void main(String[] args) {
        int arr[]={10,6,9,8,7,5};
        int temp=0;
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-i-1;j--){
                if (arr[j]>arr[j+1]){
                   temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j]=temp;

                    System.out.println(temp);
                }
            }
        }

    }
}
