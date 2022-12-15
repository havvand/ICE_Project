import java.util.ArrayList;

public class Player {
    ArrayList <Clients> playerClientPool = new ArrayList<>();
    Bank balance = new Bank();
    Agency agency = new Agency("");


    public Player(ArrayList<Clients> playerClientPool, Bank balance){
        this.balance = balance;
        this.playerClientPool = playerClientPool;
    }


}
