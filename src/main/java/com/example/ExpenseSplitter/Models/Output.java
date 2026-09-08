package com.example.ExpenseSplitter.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Output {
    private String status;
    private List<PersonPaid> owed;
}
