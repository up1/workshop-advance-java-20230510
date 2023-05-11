package com.example.day02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloController {

    @Autowired
    private MyDemoRepository repository;

    @GetMapping("/hello/say")
    public MessageResponse sayHi() {
        Optional<MyData> result = repository.findById(1);
        return new MessageResponse(result.get().getId(), result.get().getData());
    }
}
