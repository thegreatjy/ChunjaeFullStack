package com.study.ex02_javacodedi;

import com.study.ex02_javacodedi.bean.Config;
import com.study.ex02_javacodedi.bean.Member;
import com.study.ex02_javacodedi.bean.Printer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

 // @SpringBootApplication
public class Ex02JavaCodeDiApplication {

    public static void main(String[] args) {
        //SpringApplication.run(Ex02JavaCodeDiApplication.class, args);

        // 1. IoC 컨테이너 생성
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // 2. Member Bean 가져오기
        Member member1 = (Member) context.getBean("member1");
        member1.print();

        // 3. Member Bean 가져오기
        Member member2 = (Member)context.getBean("hello", Member.class);
        member2.print();

        // 4. PrinterB Bean 가져오기
        Printer printer = context.getBean("printerB", Printer.class);
    }

}
