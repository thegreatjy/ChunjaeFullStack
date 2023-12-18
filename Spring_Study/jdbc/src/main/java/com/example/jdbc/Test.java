package com.example.jdbc;

public class Test {
    public static void main(String[] args) {
        int level = 5;
        String result = "";

        for(int i=0; i<level; i++){
            result += " ".repeat(level - (i+1));
            result += "*".repeat(2*i+1);
            result += "\n";
        }

        System.out.println(result);
    }
}
