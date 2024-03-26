package com.itheima;

import com.itheima.run.Location;
import com.itheima.run.Run;
import com.itheima.streamsDemo.StreamDemo1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@SpringBootApplication//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
@RestController
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        log.info("Application started successfully"); //在dos控制台中输入类似日志的格式， 而不是使用System.out.println这种方式。.

        Run run = new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.OUTDOOR);
        /*log.atError().log("First Error: This is an error message");
        log.debug("Debug: This is a debug message!"); //这个输出没有在控制台中显示，因为logging.level.com.root=info这是默认的日志级别配置， 可以在application.properties中配置logging.level.com.root=debug， 从而显示debug级别的日志。
        log.warn("Warning: This is a warning message!!!");
        log.error("Error: This is an error message!");*/
        log.info("Run: {}", run);

        StreamDemo1 demo1 = new StreamDemo1();
        demo1.test4();


    }

    /**
     * 测试字符串的比较
     */
    private void test1() {
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        char f = 'a';
        String g = "abc";

        System.out.println((a == c));
        System.out.println((a == e));
        System.out.println((a == "hello2"));

        System.out.println((a == "hello" + 2));
        System.out.println((c == "hello" + 2));
        System.out.println((e == "hello" + 2)); //java会默认判断内存地址， 而不是值

        System.out.println((e.equals("hello" + 2))); //这个是比较值， 而不是内存地址。


        //非常好的一个用来测试短路与短路或的例子。
        int aa = 10;
        int bb = 10;
        boolean result = (aa < 10) && (bb++ < 10);
        System.out.println("result = " + result + ", aa = " + aa + ", bb = " + bb);
        result = (aa < 10) & (bb++ < 10);
        System.out.println("result = " + result + ", aa = " + aa + ", bb = " + bb);
    }

    /**
     * asList方法的测试
     */
    private void test2() {
        Integer[] arr = {1, 2, 3, 4, 5};
        int[] arr1 = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr: " + arr[i] + ", arr1: " + arr1[i]);
        }


        List list = Arrays.asList(arr);
        List list1 = Arrays.asList(arr1);
        System.out.println("list.size = " + list.size());
        System.out.println("list1.size = " + list1.size());

//        list.add(4);

//        for( int i = 0; i < list.size(); i++){
//            System.out.println("list: "+list.get(i));
//        }
    }



    @GetMapping("/home")
    public String home() {
        return "Welcome to Spring Boot!";
    }
}