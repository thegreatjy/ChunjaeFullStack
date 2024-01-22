package kr.co.chunjae;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class Example03Controller {
    @GetMapping("/exam03")
    public Person submit3(){
        Person person = new Person();

        person.setName("HolGinDong");
        person.setAge("20");
        person.setEmail("Hong@naver.com");

        return person;
    }

    @GetMapping("/exam04")
    public ResponseEntity<Person> submit4(){
        Person person = new Person();

        person.setName("HolGinDong");
        person.setAge("20");
        person.setEmail("Hong@naver.com");

        // return new ResponseEntity("person", HttpStatus.BAD_REQUEST);
        return new ResponseEntity("person", HttpStatus.OK);
    }
}
