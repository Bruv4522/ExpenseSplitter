package com.example.ExpenseSplitter.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
public class Output {
    private String status;
    private String from;
    private String dueTo;
    private int total;
    private HashMap<String, Integer> owed;
}
