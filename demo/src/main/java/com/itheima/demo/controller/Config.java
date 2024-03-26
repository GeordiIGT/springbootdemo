package com.itheima.demo.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix="person1")
public class Config {
    public List<String> getAddress() {
        return address;
    }

    public List<String> address = new ArrayList<>();

}
