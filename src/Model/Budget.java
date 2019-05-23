package Model;

import java.util.ArrayList;

public class Budget {
    private double income;
    private ArrayList<ExpenseItem> expenses;

    public Budget() {
        income = 0.00;
        expenses = new ArrayList<>();
    }

    public Budget(double income) {
        this.income = income;
        expenses = new ArrayList<>();
    }

    public double getIncome() {
        return income;
    }

    public boolean setIncome(double income) {
        if(income < 0.00) {
            return false;
        }
        else {
            this.income = income;
            return true;
        }
    }

    public boolean addExpense(String name, double amount) {
        ExpenseItem item = new ExpenseItem();

        item.setName(name);
        if(item.setAmount(amount)) {
            expenses.add(item);
            return true;
        }
        else {
            return false;
        }
    }

    public double calcBudget() {
        if(expenses.size() <= 0) {
            return income;
        }

        double totalExpenses = 0.00;

        for (ExpenseItem item : expenses) {
            totalExpenses += item.getAmount();
        }

        return income - totalExpenses;
    }
}
