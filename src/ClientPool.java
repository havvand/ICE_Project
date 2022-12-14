import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientPool
{
    //Clients client = null;
    ArrayList<Clients> clientPool = new ArrayList<>();
    Clients client = new Clients("", "", "", 0,0, 0, 0, 0);

    public ClientPool()
    {
    }

    public void initializeClientPool()
    {
        if(clientPool.size() < 50)
        {
            for(int i = 0; i < 50; i++)
            {
               clientPool.add(client.newClient(1, i+1));

               System.out.println("ID: " + clientPool.get(i).id + "\n Name " + clientPool.get(i).firstName + "\n Age: " + clientPool.get(i).age + "\n Position " + clientPool.get(i).position);
               System.out.println(" Potential : " + clientPool.get(i).potential);

            }
            if(clientPool.size() >= 50)
            {
                for(int i = 50; i < 250; i++)
                {
                    clientPool.add(client.newClient(2, i+1));

                    System.out.println("ID: " + clientPool.get(i).id + "\n Name " + clientPool.get(i).firstName + "\n Age: " + clientPool.get(i).age + "\n Position " + clientPool.get(i).position);
                    System.out.println(" Potential : " + clientPool.get(i).potential);
                }
                if(clientPool.size() >= 150)
                {
                    for (int i = 250; i < 450; i++)
                    {
                        clientPool.add(client.newClient(3, i + 1));

                        System.out.println("ID: " + clientPool.get(i).id + "\n Name " + clientPool.get(i).firstName + "\n Age: " + clientPool.get(i).age + "\n Position " + clientPool.get(i).position);
                        System.out.println(" Potential : " + clientPool.get(i).potential);
                    }
                }
                if(clientPool.size() >= 250)
                {
                    for (int i = 450; i < 550; i++)
                    {
                        clientPool.add(client.newClient(4, i + 1));

                        System.out.println("ID: " + clientPool.get(i).id + "\n Name " + clientPool.get(i).firstName + "\n Age: " + clientPool.get(i).age + "\n Position " + clientPool.get(i).position);
                        System.out.println(" Potential : " + clientPool.get(i).potential);
                    }
                }
            }
        }
    }

    public void addToClientPoolTxt()
    {
        clearCsv();

        for(int i = 0; i < 50; i++)
        {
            try {
                client = client.newClient(1, i + 1);
                //Scanner reader = new Scanner("data/userdata.txt");
                FileWriter writer = new FileWriter("data/clientpool.csv", true);
                writer.write(client.id + ";" + client.firstName + ";" + client.age + ";" + client.position + ";" + client.potential + ";" +  client.skill + ";" + client.transferValue +";\n");
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

    }

    public void replacePlayer()
    {
        try {
            System.out.println("REPLACE");
            FileReader clientpool = new FileReader("data/clientpool.csv");
            BufferedReader br = new BufferedReader(clientpool);
            Scanner reader = new Scanner(clientpool);

            if(reader.hasNextLine())
            {
                System.out.println(client.id);
                if(client.age > 20) {
                    try {
                        //client = client.newClient(1, i + 1);
                        //Scanner reader = new Scanner("data/userdata.txt");
                        System.out.println("client NAME " + client.firstName);
                        FileWriter writer = new FileWriter("data/clientpool.csv", true);
                        writer.write("REPLACED" + client.id + ";" + client.firstName + ";" + client.age + ";" + client.position + ";" + client.potential + ";" + client.skill + ";" + client.transferValue + ";\n");
                        writer.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
            }

            } catch (FileNotFoundException e)
        {
            System.out.println("FUCK");
        }

    }

    public void addNewClient()
    {
        int goalKeeper = 0;
        int defender = 0;
        int midfield = 0;
        int forward = 0;

        for(Clients c : clientPool) {
            if (c.position.equals("Goalkeeper"))
            {
                goalKeeper++;
                System.out.println("int GoalK " + goalKeeper);
            }
            if (c.position.equals("Defender"))
            {
                defender++;
                System.out.println("int Defender " + defender);
            }
            if (c.position.equals("Midfield"))
            {
                midfield++;
                System.out.println("int Midfield " + midfield);
            }
            if (c.position.equals("Forward"))
            {
                forward++;
                System.out.println("int Forward " + forward);
            }
        }
    }

    public static void clearCsv() {
        try
        {
        FileWriter writer = new FileWriter("data/clientpool.csv", false);
        PrintWriter pw = new PrintWriter(writer, false);
        pw.flush();
        pw.close();
        writer.close();
        } catch (IOException e)
        {

        }
    }
    public void removeClientFromPool(Clients client) {
        //removes prospective client from clientPool as they're no longer available
        clientPool.remove(client);
    }
}