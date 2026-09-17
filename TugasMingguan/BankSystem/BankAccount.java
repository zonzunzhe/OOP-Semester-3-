public class BankAccount{
    private double current_balance;
    private static int validTransactionCount = 0;

    public BankAccount(double current_balance) {
        if (current_balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.current_balance = current_balance;
    }
    public double getCurrentBalance(){
        return this.current_balance;
    }
    public void setCurrentBalance(double balance){
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.current_balance=balance;
    }
    public double deposito(double balance){
        if (balance <= 0) {
            throw new IllegalArgumentException("Deposit must be greater than zero");
        }
        validTransactionCount++;
        return balance + getCurrentBalance();
    }
    public double withdraw(double balance){
        if (balance <= 0) {
            System.err.println("Withdrawal must be greater than zero");
            return this.current_balance;
        }
        if (balance <= getCurrentBalance()){
            validTransactionCount++;
            return  getCurrentBalance() - balance;
        }
        else {
            System.err.println("Insuficient Balance");
            return this.current_balance;
        }
    }

    public static int getValidTransactionCount() {
        return validTransactionCount;
    }
}
