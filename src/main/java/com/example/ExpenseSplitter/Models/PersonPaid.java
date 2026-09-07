package com.example.ExpenseSplitter.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonPaid {
    private String name;
    private int amount;
}
