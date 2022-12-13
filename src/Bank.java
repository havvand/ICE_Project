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
        return getBalance() >= 0;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
