package com.example.ExpenseSplitter.Controllers;

import com.example.ExpenseSplitter.Models.Expense;
import com.example.ExpenseSplitter.Models.Message;
import com.example.ExpenseSplitter.Models.Output;
import com.example.ExpenseSplitter.Services.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HomeController {
    private final ExpenseService service;

    @GetMapping
    public Message home() {
        return new Message("This is the overengineered expense splitter API");
    }

    @GetMapping("/expense")
    public Output expense(@RequestBody Expense e) {
        return service.calculate(e);
    }
}

