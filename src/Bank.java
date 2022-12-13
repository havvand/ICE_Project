import java.util.Random;

public class Bank {
    private int balance;
    private int tax;

    public int addMoney(int amountToAdd) {

       return balance += amountToAdd;
    }

    public int withdrawMoney(int amountToWithdraw) {

        return balance - amountToWithdraw;
    }

    public void taxes() {
        balance -= tax;
    }

    public boolean isBankrupt() {
       /* if (getBalance() > 0 && turns >= 5) {
            System.out.println("Game Over! - Your agency is bankrupt");
            //return to main menu
            return true;
        }*/
        return false;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void displayBalance(){
        Bank bank = new Bank();
        System.out.println(bank.getBalance());
    }
}
