import java.util.Scanner;
public class BankAccountDemo{
    public static void main(String[] args) {
        BankAccount account=new BankAccount(100000.0);
        Scanner input = new Scanner(System.in);
        while (true) { 
            System.out.println("Your Balance :" + account.getCurrentBalance());
            System.out.println("1. Deposito");
            System.out.println("2. Withdraw");
            System.out.println("0. Exit");
            System.out.println("Chose Your Action :");
            int option = input.nextInt();
            if (option == 1){
                System.out.println("Input Deposito :");
                double depo=input.nextDouble();
                double result= account.deposito(depo);
                account.setCurrentBalance(result);
            }
            else if (option == 2){
                System.out.println("Input Withdrawal :");
                double tarik=input.nextDouble();
                double result= account.withdraw(tarik);
                account.setCurrentBalance(result);
            }
            else if (option == 0){
                break;
            }
            else{
                System.out.println("Invalid Option");
            }
        }
    }
}