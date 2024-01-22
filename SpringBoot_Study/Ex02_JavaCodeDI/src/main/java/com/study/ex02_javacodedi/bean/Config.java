package com.study.ex02_javacodedi.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    // 빈 : spring이 ioc방식으로 관리하는 객체
    // 빈 팩토리 : 스프링의 ioc를 담당하는 핵심 컨테이너
    // 애플리케이션 컨텍스트 : 빈 팩토리를 확장한 ioc 컨테이너

    @Bean
    public Member member1(){
        // setter injection (setter 메서드를 이용한 의존성 주입)
        Member member1 = new Member();
        member1.setName("홍길동");
        member1.setNickname("도사");
        member1.setPrinter(new PrinterA());

        return member1;
    }

    @Bean(name="hello")
    public Member member2(){
        // constructor injection (생성자를 이용한 의존성 주입)
        Member member2 = new Member("전우치", "도사", new PrinterA());
        return member2;
    }

    @Bean
    public PrinterA printerA(){
        return new PrinterA();
    }

    @Bean
    public PrinterB printerB(){
        return new PrinterB();
    }
}
