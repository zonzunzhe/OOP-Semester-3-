public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(double initial_balance, double interestRate) {
        super(initial_balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getCurrentBalance() * interestRate;
        setCurrentBalance(getCurrentBalance() + interest);
    }

    @Override
    public void printInfo() {
        System.out.println("Akun Tabungan (Savings) | Saldo: " + getCurrentBalance() + " | Bunga: " + (interestRate * 100) + "%");
    }
}