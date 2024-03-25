package com.itheima.demo.controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class JavaClassRestController {
//    @GetMapping("/hello")
//    public String hello() {
//        return "Hello, World!";
//    }

    @GetMapping("/demo")
    public int func1() {
        return 1;
    }

    @GetMapping("/demo2/{id}")
    public int func2(@PathVariable int id) {
        return id;
    }
    @GetMapping("/demo3/{id}/{name}")
    public String func3(@PathVariable int id, @PathVariable String name) {
        return name+id;
    }

    @GetMapping("/demo4")
    public String func4(@RequestParam String name, @RequestParam int id, @RequestParam String address) {
        return name+id+address;
    }

    @PostMapping("/demo5")
    public Data func5(@RequestBody Data data) {
        Data newData = new Data(data.getName(), data.getId(), data.getAddress());
        newData.setId(40);
        return newData;
    }

    @PostMapping("/spin")
    public SpinResponse spin(@RequestBody SpinRequest spinRequest) {
        return new SpinResponse();
    }

}
