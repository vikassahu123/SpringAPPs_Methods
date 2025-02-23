package com.Spring_apps.SpringApps.ServiceLayer;

import com.Spring_apps.SpringApps.Repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleGreeting {

    public static String getGreeting()
    {

        return "Hello World";
    }

    //  this code is for repository
    @Autowired
    private GreetingRepository greetingRepository;

    public void saveGreeting(String message) {
        greetingRepository.save(message); // call same method by same class obj.
    }

    public String getGreeting2() {
        return greetingRepository.find();  // call same method by same class obj.
    }
}
