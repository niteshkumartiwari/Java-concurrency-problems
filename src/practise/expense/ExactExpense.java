package practise.expense;

import practise.model.ExpenseMeta;
import practise.model.User;
import practise.split.ExactSplit;
import practise.split.Split;

import java.util.List;

public class ExactExpense extends Expense{

    public ExactExpense(double amount, User paidBy, List<Split> splits, ExpenseMeta expenseMeta) {
        super(amount, paidBy, splits, expenseMeta);
    }

    @Override
    public boolean validate() {
        for(Split split: getSplits()){
            if(!(split instanceof ExactSplit))return false;
        }

        double totalAmount= getAmount();
        double splitAmount=0;

        for(Split split: getSplits()){
            ExactSplit exactSplit=(ExactSplit) split;
            splitAmount+= exactSplit.getAmount();
        }

        if(totalAmount != splitAmount) return false;

        return true;
    }
}
