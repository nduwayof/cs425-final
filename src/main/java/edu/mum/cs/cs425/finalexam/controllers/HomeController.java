package edu.mum.cs.cs425.finalexam.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(path = "/")
    public String home(){
        return "pages/index";
    }

}
