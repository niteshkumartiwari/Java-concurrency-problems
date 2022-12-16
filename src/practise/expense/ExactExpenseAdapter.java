package practise.expense;

import practise.model.ExpenseMeta;
import practise.model.User;
import practise.split.Split;

import java.util.List;

public class ExactExpenseAdapter implements ExpenseAdapter{
    public ExactExpenseAdapter(){

    }

    @Override
    public Expense getExpense(double amount, User paidBy, List<Split> splits, ExpenseMeta expenseMeta) {
        return new ExactExpense(amount,paidBy,splits,expenseMeta);
    }
}
