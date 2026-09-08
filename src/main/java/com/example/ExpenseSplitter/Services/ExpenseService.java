package com.example.ExpenseSplitter.Services;

import com.example.ExpenseSplitter.Models.Expense;
import com.example.ExpenseSplitter.Models.PersonPaid;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class ExpenseService {
    public List<PersonPaid> calculate(Expense e) {
        int paid = 0;
        int eachOwes = e.getTotal() / e.getPeople().size();

        for (PersonPaid person : e.getPaidBy()) {
            paid += person.getAmount();
        }

        if (paid >= e.getTotal()) {
            return null;
        }

        List<PersonPaid> owed = new ArrayList<>();

        for (String person : e.getPeople()) {
            owed.add(new PersonPaid(person, eachOwes));
        }

        for (PersonPaid person : owed) {
            if (e.getPaidBy().contains(person)) {
                int amount = e.getPaidBy()
                        .stream()
                        .filter(p -> p.getName().equals(person.getName()))
                        .findAny()
                        .orElseThrow(() -> new IllegalArgumentException("Person not found"))
                        .getAmount();

                person.setAmount(amount);
            }
        }

        return owed;
    }
}
