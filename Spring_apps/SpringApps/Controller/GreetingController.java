package com.Spring_apps.SpringApps.Controller;

import com.Spring_apps.SpringApps.ServiceLayer.SimpleGreeting;
import org.springframework.web.bind.annotation.*;

import java.sql.PseudoColumnUsage;
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


    // UC2 Simple Greeting by service layer

    @GetMapping("/service")
   public String getValue()
    {
        return SimpleGreeting.getGreeting();// simple call because static method
    }


    // UC3 parameter 1.first+last 2.first 3.last 4.hello world
    // @RequestParam(required="false") ==> both first or last is optional
    //http://localhost:8080/Gretting/parameter?firstName=vikas&lastName=sahu
    @GetMapping("/parameter")
    public String thirdProblem(
                 @RequestParam(required = false) String firstName,
                 @RequestParam(required = false) String lastName    )
    {
        if(firstName!=null && lastName!=null)
        {
            return "Hello "+firstName+" "+ lastName+" !";
        }
        else if(firstName!=null) {
            return "Hello " + firstName + " ! ";
        }
        else if(lastName!=null) {
            return "Hello " + lastName + " ! ";
        }
        else {
            return SimpleGreeting.getGreeting();
        }
    }
}
