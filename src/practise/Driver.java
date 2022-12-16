package practise;

import practise.expense.ExpenseType;
import practise.model.User;
import practise.split.EqualSplit;
import practise.split.ExactSplit;
import practise.split.PercentageSplit;
import practise.split.Split;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        ExpenseManager expenseManager= new ExpenseManager();

        expenseManager.addUser(new User("u1","Shyam","12345","foo@bar"));
        expenseManager.addUser(new User("u2","Ram","12345","foo@bar"));
        expenseManager.addUser(new User("u3","Ravan","12345","foo@bar"));
        expenseManager.addUser(new User("u4","Sita","12345","foo@bar"));

        Scanner scanner= new Scanner(System.in);

        while (true){
            String command= scanner.nextLine();
            String[] commands= command.split(" ");
            String commandType= commands[0];

            switch (commandType){
                case "SHOW":
                    if(commands.length == 1)
                        expenseManager.showBalances();
                    else
                        expenseManager.showBalance(commands[1]);
                    break;
                case "EXPENSE":
                    String paidBy= commands[1];
                    Double amount= Double.parseDouble(commands[2]);
                    int noOfUsers= Integer.parseInt(commands[3]);
                    String expenseType= commands[4 + noOfUsers];
                    List<Split> splits = new ArrayList<>();
                    switch (expenseType){
                        case "EQUAL":
                            for(int i=0;i<noOfUsers;i++){
                                splits.add(new EqualSplit(expenseManager.userMap.get(commands[4 + i])));
                            }
                            expenseManager.addExpense(ExpenseType.EQUAL,amount,paidBy,splits,null);
                            break;
                        case "EXACT":
                            for(int i=0;i<noOfUsers;i++){
                                splits.add(new ExactSplit(expenseManager.userMap.get(commands[4+i]), Double.parseDouble(commands[5+i+noOfUsers])));
                            }
                            expenseManager.addExpense(ExpenseType.EXACT,amount,paidBy,splits,null);
                            break;
                        case "PERCENT":
                            for(int i=0;i<noOfUsers;i++){
                                splits.add(new PercentageSplit(expenseManager.userMap.get(commands[4+i]), Double.parseDouble(commands[5+i+noOfUsers])));
                            }
                            expenseManager.addExpense(ExpenseType.PERCENTAGE, amount,paidBy,splits,null);
                            break;
                    }
            }

        }
    }
}
