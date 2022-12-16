package practise.expense;

import practise.model.ExpenseMeta;
import practise.model.User;
import practise.split.PercentageSplit;
import practise.split.Split;

import java.util.List;

public class PercentageExpense extends Expense{
    public PercentageExpense(double amount, User paidBy, List<Split> splits, ExpenseMeta expenseMeta) {
        super(amount, paidBy, splits, expenseMeta);
    }

    @Override
    public boolean validate() {
        for(Split split: getSplits()){
            if(!(split instanceof PercentageSplit)) return false;
        }

        double totalPercentage = 100.0;
        double splitPercentage=0.0;

        for(Split split :  getSplits()){
            PercentageSplit percentageSplit= (PercentageSplit) split;
            splitPercentage+= percentageSplit.getPercentage();
        }

        if(totalPercentage != splitPercentage) return  false;

        return true;
    }
}
