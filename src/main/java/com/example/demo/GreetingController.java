package com.example.demo;

import com.example.demo.model.Action;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.swing.text.html.HTMLDocument;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController extends HttpServlet {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired private ActionsRepository actionsRepository;




    @RequestMapping("/gr")
    public Greet greeting(@RequestParam(value="name", required=false, defaultValue="World") String name){

        return new Greet(counter.incrementAndGet(), String.format(template, name));
    }


    @RequestMapping("/test")
    public String test() {
        String str = "<img src=\"https://cataas.com/cat/gif\"></img>";
        return str;

    }
}
