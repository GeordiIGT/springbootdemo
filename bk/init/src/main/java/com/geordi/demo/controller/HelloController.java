package com.geordi.demo.controller;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired; //why it is grey?
import org.springframework.beans.factory.annotation.Value;


@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
//        System.out.println(name+ " Guo");
        System.out.println(name2+ " Guo");
        System.out.println(age);
        System.out.println(gender);
        System.out.println(address[0]); //when I call address[0] it print with a [ at the beginning;
        System.out.println(address[1]); //when I call address[0] it print with a [ at the beginning;
        System.out.println(address.length);
        System.out.println(msg1);
        System.out.println(env.getProperty("person1.msg2")); //？？？？？？单引号的忽略转义字符的原则貌似不管用了呢
        System.out.println(msg3);
        return "Hello Spring Boot!!!"+name;
    }

    @Value("${name}")
    private String name;
    @Value("${person1.name}")
    private String name2;

    @Value("${person1.age}")
    private int age;

    @Value("${person1.gender}")
    private String gender;

    @Value("${person1.address}")
    private String[] address;

    @Value("${person1.msg1}")
    private String msg1;

    @Value("${person1.msg2}")
    private String msg2;

    @Value("${person1.msg3}")
    private String msg3;

    @Autowired
    private Environment env;
}
