package com.itheima.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();
    List<Run> findAll() {
        return runs;
    }

    Run findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst()
                .get();
    }
    @PostConstruct
    private void init() {
        runs.add(new Run(1, "First run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR));
        runs.add(new Run(2, "Second run", LocalDateTime.now(), LocalDateTime.now().plusHours(2), 10, Location.INDOOR));
    }
}
