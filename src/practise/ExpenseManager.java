package practise;

import practise.expense.Expense;
import practise.expense.ExpenseCommand;
import practise.expense.ExpenseType;
import practise.model.ExpenseMeta;
import practise.model.User;
import practise.split.Split;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    List<Expense> expenses;
    Map<String, User> userMap;
    Map<String, Map<String, Double>> balanceSheet;
    ExpenseCommand expenseCommand;

    public ExpenseManager(){
        expenses= new ArrayList<>();
        userMap= new HashMap<>();
        balanceSheet= new HashMap<>();
        expenseCommand= new ExpenseCommand();
    }

    public void addUser(User user){
        userMap.put(user.getId(), user);
        balanceSheet.put(user.getId(), new HashMap<>());
    }

    public void addExpense(ExpenseType expenseType, double amount, String paidBy, List<Split> splits, ExpenseMeta expenseMeta){
        Expense expense= expenseCommand.getExpense(expenseType,amount,userMap.get(paidBy),splits,expenseMeta);
        expenses.add(expense);

        for(Split split: splits){
            String paidTo= split.getUser().getId();

            //Update Balance Sheet of paidBy
            Map<String,Double> balances= balanceSheet.get(paidBy);
            if(!balances.containsKey(paidTo)){
                balances.put(paidTo,0.0);
            }
            balances.put(paidTo, balances.get(paidTo)+split.getAmount());

            //Update Balance Sheet of paidTo
            balances= balanceSheet.get(paidTo);
            if(!balances.containsKey(paidBy)){
                balances.put(paidBy,0.0);
            }
            balances.put(paidBy, balances.get(paidBy)-split.getAmount());
        }
    }

    public void showBalance(String userId){
        boolean isEmpty= true;
        for(Map.Entry<String, Double> userBalance: balanceSheet.get(userId).entrySet()){
            if(userBalance.getValue() !=0){
                isEmpty=false;
                printBalance(userId, userBalance.getKey(), userBalance.getValue());
            }
        }

        if(isEmpty){
            System.out.println("No balances");
        }
    }

    public void showBalances(){
        boolean isEmpty = true;
        for (Map.Entry<String, Map<String, Double>> allBalances : balanceSheet.entrySet()) {
            for (Map.Entry<String, Double> userBalance : allBalances.getValue().entrySet()) {
                if (userBalance.getValue() > 0) {
                    isEmpty = false;
                    printBalance(allBalances.getKey(), userBalance.getKey(), userBalance.getValue());
                }
            }
        }

        if (isEmpty) {
            System.out.println("No balances");
        }
    }

    private void printBalance(String user1, String user2, double amount){
        String user1Name= userMap.get(user1).getName();
        String user2Name= userMap.get(user2).getName();

        if(amount<0){
            System.out.println(user1Name +" owes "+ user2Name+" : "+ Math.abs(amount));
        }else{
            System.out.println(user2Name +" owes "+ user1Name+" : "+ Math.abs(amount));
        }
    }
}
