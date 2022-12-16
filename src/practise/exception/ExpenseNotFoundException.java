package practise.exception;

public class ExpenseNotFoundException extends RuntimeException{
    public ExpenseNotFoundException(String message) {
        super("Expense not found: "+ message);
    }
}
