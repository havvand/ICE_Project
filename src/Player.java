import java.util.ArrayList;

public class Player {
    ArrayList <Clients> playerClientPool = new ArrayList<>();
    Bank ballance = new Bank(0);


    public Player(ArrayList<Clients> playerClientPool, Bank ballance){
        this.ballance = ballance;
        this.playerClientPool = playerClientPool;
    }

}
