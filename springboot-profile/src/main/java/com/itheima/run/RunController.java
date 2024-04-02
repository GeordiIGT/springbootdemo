package com.itheima.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}") //@RequestMapping(mothod=RequestMethod.GET, value="/{id}")
    Run findById(@PathVariable Integer id){
        Optional<Run> run = this.runRepository.findById(id);
        if(run.isEmpty()){
            throw new RunNotFoundException();
        }
        return run.get(); //必须要用get()方法吗?
//        return this.runRepository.findById(id);
    }

    //post, create a Run
    @ResponseStatus(HttpStatus.CREATED) //返回状态码201, 不加的话状态码默认是200
    @PostMapping("")                    //RequestMapping(method=RequestMethod.POST, value="")
    void create(@RequestBody Run run){  // added annotation @RequestBody so that the request body can be converted to a Run object
        this.runRepository.create(run);
    }

    //put, update a Run
    @PutMapping("/{id}")                //RequestMapping(method=RequestMethod.PUT, value="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //返回状态码204, 不加的话状态码默认是200
    void update(@RequestBody Run run, @PathVariable Integer id){
        this.runRepository.update(run, id);
    }

    //delete a Run
    @DeleteMapping("/{id}") //注册这个URL可以对delete请求进行解析
    @ResponseStatus(HttpStatus.NO_CONTENT) //返回状态码204, 不加的话状态码默认是200
    void delete(@PathVariable Integer id){
        this.runRepository.delete(id);
    }
}

