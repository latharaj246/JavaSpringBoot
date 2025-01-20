package com.latha.FirstSpringApplication;


import org.springframework.web.bind.annotation.*;

@RestController
public class HelloControler {

    //Get Request
    @GetMapping("/hello1")
    public HelloResponse hello() {
        // return "Hello World";
        return new HelloResponse("Hello World");
        //returning the object of this type
        //RestController has Restresponse (Message converters jakson liberary converter)

    }

    //Post Request
    @PostMapping("/hello")
    public HelloResponse hellpPost(@RequestBody String name) {
        return new HelloResponse("Hello " + name + "!");
    }

    //Adding a path Variable
    @GetMapping("/PathVariable/{name}")
    public HelloResponse Path(@PathVariable String name) {

        return new HelloResponse("Hello ," + name);

    }

}
