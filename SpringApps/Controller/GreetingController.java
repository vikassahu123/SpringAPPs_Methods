package com.Spring_apps.SpringApps.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Gretting")
public class GreetingController {

    //UC_1 Greeting Methods
    @GetMapping
    public String say1()
    {
        return "Get mapping for greeting";

    }

    @PutMapping
    public String say2()
    {
        return "Put mapping for greeting";

    }

    @PostMapping
    public String say3()
    {
        return "Post mapping for greeting";

    }

    @DeleteMapping
    public String say4()
    {
        return "Delete mapping for greeting";

    }

    @GetMapping("/all")
    public Map<String,String> all()
    {
       return Map.of(                 //http://localhost:8080/Gretting/all
               "firstMethod",say1(),
               "secondMethod",say2(),
               "thirdMethod",say3(),
               "fourthMethod",say4());
    }



}
