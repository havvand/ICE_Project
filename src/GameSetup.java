import java.util.ArrayList;

public class GameSetup
{
    ClientPool pool = new ClientPool();

    public void removeClient()
    {
        //pool.initializeArrayList();
        ArrayList<Clients> poolList = pool.clientPool;
        System.out.println(poolList.get(0).id + " " + poolList.get(0).firstName);
        poolList.remove(0);
        System.out.println(poolList.get(0).id + " " + poolList.get(0).firstName);
        pool.checkClientPool();
    }

}
