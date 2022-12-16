package practise.expense;

import practise.model.ExpenseMeta;
import practise.model.User;
import practise.split.Split;

import java.util.List;

public interface ExpenseAdapter {
    Expense getExpense(double amount, User paidBy, List<Split> splits, ExpenseMeta expenseMeta);
}
