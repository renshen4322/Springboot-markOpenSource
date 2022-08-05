package com.mark.controller;

import com.mark.bean.annotation.SemaphoreLimit;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @SemaphoreLimit(key = "call", limit = 5, blockingTime = 1)
    @RequestMapping(value="/hello/{id}",method= RequestMethod.GET)  //http://localhost:8080/myBoot/hello/23
    public String sayHello(@PathVariable("id") Integer id){
        return "id:"+id;
    }

    @RequestMapping(value="/hello",method= RequestMethod.GET) //http://localhost:8080/myBoot/hello?id=23&name=xiaoming
    public String sayHello(@RequestParam("id") Integer id, @RequestParam("name") String name){
        return "id:"+id+ " name:"+name;
    }


}