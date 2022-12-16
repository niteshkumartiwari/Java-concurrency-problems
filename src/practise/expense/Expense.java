package practise.expense;

import practise.model.ExpenseMeta;
import practise.model.User;
import practise.split.Split;

import java.util.List;

public abstract class Expense {
    private String id;
    private double amount;
    private User paidBy;
    private List<Split> splits;
    private ExpenseMeta expenseMeta;

    public Expense(double amount, User paidBy, List<Split> splits, ExpenseMeta expenseMeta) {
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
        this.expenseMeta = expenseMeta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public ExpenseMeta getExpenseMeta() {
        return expenseMeta;
    }

    public void setExpenseMeta(ExpenseMeta expenseMeta) {
        this.expenseMeta = expenseMeta;
    }

    public abstract boolean validate();
}
