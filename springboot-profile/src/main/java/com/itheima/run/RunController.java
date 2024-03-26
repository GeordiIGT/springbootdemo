package com.itheima.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/runs")
public class RunController {
    private final RunRepository runRepository;

    /**
     * Achieve Singleton on instance of runRepository, by passing it in.
     */
    public RunController(RunRepository runRepository) {

        this.runRepository = runRepository;
    }
    @GetMapping("/findall") //创建了一个能够获得所有runs的接口
    List<Run> findAll(){
        return this.runRepository.findAll();
    }

    @GetMapping("/1")
    Run findById(){
        return this.runRepository.findById(1);
    }
}

