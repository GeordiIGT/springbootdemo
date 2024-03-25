package com.itheima.demo.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix="person2")
public class PersonConfig {
    public List<Person> getPerson() {
        return person;
    }

//    public void setPerson(List<Person> person) {
//        this.person = person;
//    }

    private List<Person> person = new ArrayList<>();
}
