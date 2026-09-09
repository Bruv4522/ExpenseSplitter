package com.example.ExpenseSplitter.Services;

import com.example.ExpenseSplitter.Models.Expense;
import com.example.ExpenseSplitter.Models.Output;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ExpenseService {
    public Output calculate(Expense e) {
        int paid = 0;
        int eachOwes = e.getTotal() / e.getPeople().size();
        String status = "";
        String dueTo = "";
        String from = "";
        HashMap<String, Integer> owed = new HashMap<>();

        for (String person : e.getPaidBy().keySet()) {
            if (!e.getPeople().contains(person)) {
                return new Output("Error: paid by a person not specified in the 'people' array", "None", "None", 0, new HashMap<>());
            }
        }

        for (int amount : e.getPaidBy().values()) {
            paid += amount;
        }

        if (paid > e.getTotal()) {
            status = "Overpaid";
            from = "Creditor";
            dueTo = "Each other";
            int overpayment = paid - e.getTotal();

            for (String person : e.getPeople()) {
                if (e.getPaidBy().containsKey(person)) {
                    owed.put(person, eachOwes - e.getPaidBy().get(person));
                } else {
                    owed.put(person, eachOwes);
                }
            }

            return new Output(status, from, dueTo, -overpayment, owed);
        }

        if (paid == e.getTotal()) {
            status = "Paid";
            from = "Each other";
            dueTo = "None";

            for (String person : e.getPeople()) {
                if (e.getPaidBy().containsKey(person)) {
                    if (e.getPaidBy().get(person) > eachOwes) {
                        owed.put(person, eachOwes - e.getPaidBy().get(person));
                        dueTo = "Each other";
                    }
                }
            }

            return new Output(status, from, dueTo, 0, owed);
        }

        status = "Remaining";
        from = "Each other";
        dueTo = "Creditor";
        int total = e.getTotal() - paid;

        for (String person : e.getPeople()) {
            if (e.getPaidBy().containsKey(person)) {
                if (eachOwes - e.getPaidBy().get(person) > 0){
                    owed.put(person, eachOwes - e.getPaidBy().get(person));
                }
            } else {
                owed.put(person, eachOwes);
            }
        }

        return new Output(status, from, dueTo, total, owed);
    }
}
