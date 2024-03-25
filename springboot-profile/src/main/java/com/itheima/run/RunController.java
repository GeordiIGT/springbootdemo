package com.itheima.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RunController {
    private final RunRepository runRepository;

    /**
     * Achieve Singleton on instance of runRepository, by passing it in.
     */
    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    List<Run> findAll(){
        return null;
    }
}

