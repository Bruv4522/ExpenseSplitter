package com.example.ExpenseSplitter.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Expense {
    private int total;
    private List<String> people;
    private List<PersonPaid> paidBy;
}
