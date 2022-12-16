package practise.expense;

import practise.model.ExpenseMeta;
import practise.model.User;
import practise.split.EqualSplit;
import practise.split.Split;

import java.util.List;

public class EqualExpense extends Expense{
    public EqualExpense(double amount, User paidBy, List<Split> splits, ExpenseMeta expenseMeta) {
        super(amount, paidBy, splits, expenseMeta);
    }

    @Override
    public boolean validate() {
        for(Split split: getSplits()){
            if(!(split instanceof EqualSplit)) return false;
        }
        return true;
    }
}
