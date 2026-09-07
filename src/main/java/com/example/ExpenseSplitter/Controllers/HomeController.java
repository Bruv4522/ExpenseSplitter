package com.example.ExpenseSplitter.Controllers;

import com.example.ExpenseSplitter.Models.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping
    public Message home() {
        return new Message("This is the overengineered expense splitter API");
    }
}
