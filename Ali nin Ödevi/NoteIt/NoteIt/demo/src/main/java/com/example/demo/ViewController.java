package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

public class ViewController {



    @GetMapping("/")
    public String index(){
        return "index";
    }
}
