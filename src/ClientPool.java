import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientPool
{
    ArrayList<Clients> clientPool = new ArrayList<>(); // Arraylist for counting!
    Clients client = new Clients("", "", "", 0,0, 0, 0, 0);

    public ClientPool()
    {
    }

    /*public void initializeClientPool()
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
    }*/

    public void initializeClientPoolToCsv()
    {
        initializeClientPoolArray();
        clearCsv();

        for(int i = 0; i < 50; i++)
        {
            try {
                client = client.newClient(1, i + 1);
                //Scanner reader = new Scanner("data/userdata.txt");
                FileWriter writer = new FileWriter("data/clientpool.csv", true);
                writer.write(client.id + ";" + client.firstName + ";" + client.lastName + ";" + client.age + ";" + client.position + ";" +  client.skill + ";" +  client.potential + ";" + client.transferValue +";\n");
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        for(int i = 50; i < 250; i++)
        {
            try {
                client = client.newClient(2, i + 1);
                //Scanner reader = new Scanner("data/userdata.txt");
                FileWriter writer = new FileWriter("data/clientpool.csv", true);
                writer.write(client.id + ";" + client.firstName + ";" + client.lastName + ";" + client.age + ";" + client.position + ";" +  client.skill + ";" +  client.potential + ";" + client.transferValue +";\n");
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        for(int i = 250; i < 450; i++)
        {
            try {
                client = client.newClient(3, i + 1);
                //Scanner reader = new Scanner("data/userdata.txt");
                FileWriter writer = new FileWriter("data/clientpool.csv", true);
                writer.write(client.id + ";" + client.firstName + ";" + client.lastName + ";" + client.age + ";" + client.position + ";" +  client.skill + ";" +  client.potential + ";" + client.transferValue +";\n");
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        for(int i = 450; i < 550; i++)
        {
            try {
                client = client.newClient(4, i + 1);
                //Scanner reader = new Scanner("data/userdata.txt");
                FileWriter writer = new FileWriter("data/clientpool.csv", true);
                writer.write(client.id + ";" + client.firstName + ";" + client.lastName + ";" + client.age + ";" + client.position + ";" +  client.skill + ";" +  client.potential + ";" + client.transferValue +";\n");
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public ArrayList<Clients> initializeClientPoolArray()
    {
        ArrayList<Clients> clientPoolList = new ArrayList<>(); // The arraylist for the initialized clientpool!

        for(int i = 0; i < 50; i++)
        {
            client = client.newClient(1, i + 1);
            clientPoolList.add(client);
        }
        for(int i = 50; i < 250; i++)
        {
            client = client.newClient(2, i + 1);
            clientPoolList.add(client);
        }
        for(int i = 250; i < 450; i++)
        {
            client = client.newClient(3, i + 1);
            clientPoolList.add(client);
        }
        for(int i = 450; i < 550; i++)
        {
            client = client.newClient(4, i + 1);
            clientPoolList.add(client);
        }

        for (Clients c : clientPoolList)
        {
            System.out.println("Client ID: " + c.id + "\n Name: " + c.firstName + " " + c.lastName + "\n Age: " + c.age + "\n Position: " +c.position + "\n Skill: " +  c.skill + "\n Transfer Value: " + c.transferValue);
        }

        /*try
        {
            List<String> inputLines = Files.readAllLines(Paths.get("data/clientpool.csv"), StandardCharsets.UTF_8);
            List<String> clientPoolArray = new ArrayList<>(inputLines.size());
            for(String line : inputLines)
            {
               clientPoolArray.add(line);
               System.out.println(line);
            }
            System.out.println(clientPoolArray.get(0));

        }catch(Exception e)
        {
            System.out.println("LOL");
        }*/
        return clientPoolList;
    }

    // So far the method is only checking how many of each type player there are in the pool!
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
}
