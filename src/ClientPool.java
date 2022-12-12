import java.util.ArrayList;

public class ClientPool
{
    //Clients client = null;
    ArrayList<Clients> clientPool = new ArrayList<>();

    public ClientPool()
    {
    }

    public void addClient()
    {
        Clients client = new Clients("", "", "", 0, 0, 0, 0);
        client.newClient();
        clientPool.add(client.newClient());
        for (Clients m: clientPool)
        {
            System.out.println(client.toString());
        }
        System.out.println(clientPool);
    }
}
