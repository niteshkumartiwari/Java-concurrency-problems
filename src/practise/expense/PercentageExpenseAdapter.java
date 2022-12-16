package practise.expense;

import practise.model.ExpenseMeta;
import practise.model.User;
import practise.split.PercentageSplit;
import practise.split.Split;

import java.util.List;

public class PercentageExpenseAdapter implements ExpenseAdapter{
    public PercentageExpenseAdapter(){
    }

    @Override
    public Expense getExpense(double amount, User paidBy, List<Split> splits, ExpenseMeta expenseMeta) {
        for(Split split: splits){
            PercentageSplit percentageSplit= (PercentageSplit) split;
            split.setAmount((amount*percentageSplit.getPercentage())/100.0);
        }
        return new PercentageExpense(amount,paidBy,splits,expenseMeta);
    }
}
