package com.study.ex02_javacodedi.bean;

public class PrinterB implements Printer{
    @Override
    public void print(String message) {
        System.out.println("Printer B : " + message);
    }
}
