public class Bank {
    private int balance;
    private int tax;

    public Bank(int startAmount) {
        balance = startAmount;
    }

    public void addMoney(int balance) {
        int amountToAdd = 0;

        balance += amountToAdd;
    }

    public void withdrawMoney(int balance) {
        int amountToWithdraw = 0;

        balance -= amountToWithdraw;
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
