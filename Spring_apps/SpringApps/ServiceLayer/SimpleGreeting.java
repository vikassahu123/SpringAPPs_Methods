package com.Spring_apps.SpringApps.ServiceLayer;

import org.springframework.stereotype.Service;

@Service
public class SimpleGreeting {

    public static String getGreeting()
    {
        return "Hello World";
    }
}
