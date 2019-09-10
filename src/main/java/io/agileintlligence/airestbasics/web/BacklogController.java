package io.agileintlligence.airestbasics.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller // returns view

@RestController //returns json or
//A controller class handles requests from the client, in this case http requests, and responds with data
@RequestMapping("/backlog")
//this annotation will map all http requests coming to that URI to this class and the methods inside of
public class BacklogController {

    @GetMapping
    public String test(){
        return "Test String";
    }

    @GetMapping("/urisample")
    public String test2(){
        return "Uri sample";
    }


}
