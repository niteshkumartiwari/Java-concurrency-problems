package practise.expense;

import practise.model.ExpenseMeta;
import practise.model.User;
import practise.split.Split;

import java.util.List;

public class EqualExpenseAdapter implements ExpenseAdapter{
    public EqualExpenseAdapter(){
    }

    @Override
    public Expense getExpense(double amount, User paidBy, List<Split> splits, ExpenseMeta expenseMeta) {
        int totalSplit= splits.size();
        double splitAmount= (double)(Math.round(amount*100/totalSplit))/100.0;
        for(Split split: splits){
            split.setAmount(splitAmount);
        }
        splits.get(0).setAmount(splitAmount + amount - splitAmount*totalSplit);
        return new EqualExpense(amount,paidBy,splits,expenseMeta);
    }
}
