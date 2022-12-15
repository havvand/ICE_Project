import java.io.*;
import java.util.ArrayList;

public class ClientPool {
    TextUI textUI = new TextUI();
    static ArrayList<Clients> clientPool = new ArrayList<>();
    Clients client = new Clients("", "", "", 1, 0, 0, 0, 0);
    int goalKeeper, defender, midfield, forward;

    public ClientPool() {
    }

    public void initializeArrayList() {
        clientPool = createClientPoolArray();
        System.out.println("INITALIZE ARRAYLIST " + clientPool.get(0).firstName);
    }


    public void saveArrayToCsv() {
        clearCsv();

        for (int i = 0; i < 50; i++) {
            try {
                client = client.newClient(1, 0);
                //Scanner reader = new Scanner("data/userdata.txt");
                FileWriter writer = new FileWriter("data/clientpool.csv", true);
                writer.write(client.id + ";" + client.firstName + ";" + client.lastName + ";" + client.age + ";" + client.position + ";" + client.skill + ";" + client.potential + ";" + client.transferValue + ";\n");
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        for (int i = 50; i < 250; i++) {
            try {
                client = client.newClient(2, 0);
                //Scanner reader = new Scanner("data/userdata.txt");
                FileWriter writer = new FileWriter("data/clientpool.csv", true);
                writer.write(client.id + ";" + client.firstName + ";" + client.lastName + ";" + client.age + ";" + client.position + ";" + client.skill + ";" + client.potential + ";" + client.transferValue + ";\n");
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        for (int i = 250; i < 450; i++) {
            try {
                client = client.newClient(3, 0);
                //Scanner reader = new Scanner("data/userdata.txt");
                FileWriter writer = new FileWriter("data/clientpool.csv", true);
                writer.write(client.id + ";" + client.firstName + ";" + client.lastName + ";" + client.age + ";" + client.position + ";" + client.skill + ";" + client.potential + ";" + client.transferValue + ";\n");
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        for (int i = 450; i < 550; i++) {
            try {
                client = client.newClient(4, 0);
                //Scanner reader = new Scanner("data/userdata.txt");
                FileWriter writer = new FileWriter("data/clientpool.csv", true);
                writer.write(client.id + ";" + client.firstName + ";" + client.lastName + ";" + client.age + ";" + client.position + ";" + client.skill + ";" + client.potential + ";" + client.transferValue + ";\n");
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

    }

    public ArrayList<Clients> createClientPoolArray() {
        ArrayList<Clients> clientPoolList = new ArrayList<>(); // The arraylist for the initialized clientpool!

        for (int i = 0; i < 50; i++) {
            clientPoolList.add(client.newClient(1, i));
        }
        for (int i = 50; i < 250; i++) {
            clientPoolList.add(client.newClient(2, i));

        }
        for (int i = 250; i < 450; i++) {
            clientPoolList.add(client.newClient(3, i));
        }
        for (int i = 450; i < 550; i++) {
            clientPoolList.add(client.newClient(4, i));
        }

        /*for (Clients c : clientPoolList)
        {
            System.out.println("Client ID: " + c.id + "\n Name: " + c.firstName + " " + c.lastName + "\n Age: " + c.age + "\n Position: " +c.position + "\n Skill: " +  c.skill + "\n Transfer Value: " + c.transferValue);
        }*/

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

    private void countPlayerType() {
        goalKeeper = 0;
        defender = 0;
        midfield = 0;
        forward = 0;

        for (Clients c : clientPool) {
            if (c.position.equals("Goalkeeper")) {
                goalKeeper++;
            }
            if (c.position.equals("Defender")) {
                defender++;
            }
            if (c.position.equals("Midfield")) {
                midfield++;
            }
            if (c.position.equals("Forward")) {
                forward++;
            }

        }

        System.out.println("Active goalkeepers: \n" + goalKeeper +
                "\nActive defenders: \n" + defender +
                "\nActive midfielders: \n" + midfield +
                "\nActive forwards: \n" + forward);

        System.out.println("POOL SIZE BEFORE ADD " + clientPool.size());

    }

    // So far the method is only checking how many of each type player there are in the pool!
    public void addClientsPerTurn()
    {
        countPlayerType();

        if (goalKeeper < 50)
        {
            for (int i = clientPool.size(); i < 550; i++)
            {
                clientPool.add(client.newClient(1, i));
            }

        }
        if (defender < 200)
        {
            for (int i = clientPool.size(); i < 550; i++)
            {
                clientPool.add(client.newClient(2, i));
                System.out.println(clientPool.size());
            }
        }

        if (midfield < 200)
        {
            for (int i = clientPool.size(); i < 550; i++)
            {
                clientPool.add(client.newClient(3, i));
                System.out.println(clientPool.size());
            }
        }

        if (forward < 100)
        {
            for (int i = clientPool.size(); i < 550; i++)
            {
                clientPool.add(client.newClient(4, i));
                System.out.println(clientPool.size());
            }
        }

        for (Clients c : clientPool)
        {
            System.out.println(c.position + " " + c.id + " " + c.firstName);
        }

    }


    public void removeClientFromPool ()
    {
        int input = textUI.getUserInputNum("Enter player ID to remove player!");
                //clientPool.get(177).id; // REPLACE WITH USER INPUT
        //removes prospective client from clientPool as they're no longer available
        int size = clientPool.size();
        for (int i = 0; i < clientPool.size(); ++i)
        {
            if (input == clientPool.get(i).id)
            {
                clientPool.remove(i);
            }
        }
    }


    public static void clearCsv ()
    {
        try {
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
