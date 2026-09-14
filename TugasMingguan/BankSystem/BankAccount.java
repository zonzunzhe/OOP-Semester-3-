public class BankAccount{
    private double current_balance;

    public BankAccount(double current_balance) {
        this.current_balance = current_balance;
    }
    public double getCurrentBalance(){
        return this.current_balance;
    }
    public void setCurrentBalance(double balance){
        this.current_balance=balance;
    }
    public double deposito(double balance){
        return balance + getCurrentBalance(); 
    }
    public double withdraw(double balance){
        if (balance <= getCurrentBalance()){
            return  getCurrentBalance() - balance;
        }
        else {
            System.err.println("Insuficient Balance");
            return this.current_balance;
        }
    }    
}
