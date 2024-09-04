package JAVA;
import java.util.Scanner;

class Atm{
    private int balance;
    public Atm(int initialbalance){
        this.balance=initialbalance;
    }
    public void deposit(int amount){
        this.balance+=amount;
    }  
    public void withraw(int amount){
        if(balance>=amount){
            this.balance-=amount;
        }else{
            System.out.println("Insufficient Balance");
        }
    }  
    public double checkBalance(){
        return balance;
    }

}
class BankAcount{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the initial balance in tha account");
        int initial_balance=sc.nextInt();
        Atm acc=new Atm(initial_balance);
        boolean done=false;
        while(!done){
            System.out.println("D)eposit\tW)ithraw\tC)heck Balance\t\tQ)uit");
            String input=sc.next();
            if(input.equals("D")|| input.equals("W")){
                System.out.println("Enter the amount :");
                int amount=sc.nextInt();
                if(input.equals("D")){
                    acc.deposit(amount);
                    System.out.println("Rs."+amount+" deposited to the account");
                }
                else{
                    acc.withraw(amount);
                }
            }
            else if(input.equals("C")){
                System.out.println(acc.checkBalance());
            }
            else if(input.equals("Q")){
                done=true;
            }
        }
        sc.close();
    }
}
