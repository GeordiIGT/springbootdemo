package com.itheima.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();
    List<Run> findAll() {
        return runs;
    }


    Optional<Run> findById(Integer id) {
//    Run findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();
//                .get();   //注意, 这里不能用get()方法， 因为返回值是Optional<Run>， 而不是Run
    }
    @PostConstruct
    private void init() {
        runs.add(new Run(1, "First run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR));
        runs.add(new Run(2, "Second run", LocalDateTime.now(), LocalDateTime.now().plusHours(2), 10, Location.INDOOR));
    }

    void create(Run run) {
        runs.add(run);
    }

    void update(Run run, Integer id) {
        Optional<Run> existingRun = this.findById(id);
        if(!existingRun.isEmpty()){ //或者可以用if(existingRun.isPresent()) 效果是一样的
            Integer index = runs.indexOf(existingRun.get());  // 这里用get()方法，因为返回值是Optional<Run>， 而不是Run, 但是这里的get()方法不会报错，因为上面已经判断了Optional<Run>不为空
            System.out.println("Run record index: "+index+", id="+id+" has been updated");
            this.runs.set(index, run); //这里的index值和id的值不一定是一样的. 因为在添加的过程中就没有用id作为索引
        }
    }

    void delete(Integer id){
        runs.removeIf(run ->id.equals(run.id()));
    }
}
