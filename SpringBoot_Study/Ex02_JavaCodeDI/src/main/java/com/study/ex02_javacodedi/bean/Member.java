package com.study.ex02_javacodedi.bean;

public class Member {
    String name;
    String nickname;
    Printer printer;

    public Member(){};

    public Member(String name, String nickname, Printer printer) {
        this.name = name;
        this.nickname = nickname;
        this.printer = printer;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }



    public void print(){
        printer.print("Hello "+name+": "+nickname);
    }
}

