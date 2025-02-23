package com.Spring_apps.SpringApps.Controller;

import com.Spring_apps.SpringApps.ServiceLayer.SimpleGreeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Gretting")
public class GreetingController {


    // UC_1 Greeting Methods
    @GetMapping
    public String say1() {
        return "Get mapping for greeting";
    }

    @PutMapping
    public String say2() {
        return "Put mapping for greeting";
    }

    @PostMapping
    public String say3() {
        return "Post mapping for greeting";
    }

    @DeleteMapping
    public String say4() {
        return "Delete mapping for greeting";
    }

    @GetMapping("/allMethods")
    public Map<String, String> all() {
        return Map.of(
                "firstMethod", say1(),
                "secondMethod", say2(),
                "thirdMethod", say3(),
                "fourthMethod", say4()
        );
    }

    // UC2 Simple Greeting by service layer
    @GetMapping("/service")
    public String getValue() {
        return SimpleGreeting.getGreeting();
    }

    // UC3: Greeting with first and last name
    @GetMapping("/parameter")
    public String thirdProblem(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello " + firstName + "!";
        } else if (lastName != null) {
            return "Hello " + lastName + "!";
        } else {
            return SimpleGreeting.getGreeting();
        }
    }

    // UC4:  save greeting into repository

    @Autowired
    private  SimpleGreeting simpleGreeting;

    @PostMapping("/save")
    public String saveGreeting(@RequestBody String message) {
         simpleGreeting.saveGreeting(message);
         return "Greeting saved successfully ! ";
    }

    @GetMapping("/getgreeting")
    public String getGreeting() {
        return simpleGreeting.getGreeting2();
    }


    // UC5 find a Greeting Message by Id in the Repository

    // uc5 save greeting by id and fetch
    @PostMapping("/id/{id}")
    public String saveGreeting(@PathVariable Long id, @RequestBody String message) {
        simpleGreeting.saveGreetingbyid(id, message);
        return "Greeting saved with ID: " + id;
    }

    @GetMapping("/id/{id}")
    public String getGreeting(@PathVariable Long id) {
        return simpleGreeting.getGreetingById(id);
    }

    //........................
    // uc6 showing all the messages
        @GetMapping("/all")
        public Map<Long, String> getAllGreetings() {
            return simpleGreeting.getAllGreetings();
        }

     //......................
     // uc7 here i am updating  the greeting message stored by id
     @PutMapping("/id/{id}")
     public String updateGreeting(@PathVariable Long id, @RequestBody String newMessage) {
         String response = simpleGreeting.updateGreeting(id, newMessage);
         return response;
     }
}
