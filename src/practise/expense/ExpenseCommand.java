package practise.expense;

import practise.exception.ExpenseNotFoundException;
import practise.model.ExpenseMeta;
import practise.model.User;
import practise.split.Split;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseCommand {
    private static final Map<ExpenseType, ExpenseAdapter> EXPENSE_MAP= new HashMap<>();;

    public ExpenseCommand() {
        EXPENSE_MAP.put(ExpenseType.EQUAL, new EqualExpenseAdapter());
        EXPENSE_MAP.put(ExpenseType.EXACT, new ExactExpenseAdapter());
        EXPENSE_MAP.put(ExpenseType.PERCENTAGE, new PercentageExpenseAdapter());
    }

    public void addSplitAdapter(ExpenseType splitType, ExpenseAdapter expenseAdapter){
        EXPENSE_MAP.put(splitType,expenseAdapter);
    }

    public Expense getExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splits, ExpenseMeta expenseMetadata){
        ExpenseAdapter expenseAdapter= EXPENSE_MAP.get(expenseType);
        if(expenseAdapter == null){
            throw new ExpenseNotFoundException(expenseType.toString());
        }

        return expenseAdapter.getExpense(amount,paidBy,splits,expenseMetadata);
    }
}
