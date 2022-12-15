import java.util.ArrayList;

public class Agency {
    static String name;
    Bank b = new Bank();
    TextUI textUI = new TextUI();
    private int bureauLevel;
    public static ArrayList<Clients> agency = new ArrayList<>();


    public Agency(String name){
        this.name = name;
            }
    public int getBureauLevel() {
        return bureauLevel;
    }
    public void addClientToAgency(Clients c) {
        //adds the prospective client to Agency
        agency.add(c);
    }
    public void removeClientFromAgency(Clients c) {
        agency.remove(c);
    }

    public void upgradeAgency() {
        bureauLevel += 1;
        b.withdrawMoney(10000000*bureauLevel);
        System.out.println("You have upgraded your agency! \nThe construction cost amounted to: " + 10000000*bureauLevel + "\n");
    }

    public ArrayList<Clients> getPortFolio()
    {
        System.out.println("h2ej");
        for (Clients c: agency)
        {
            System.out.println(c.id+" Name: "+ c.firstName+" "+c.lastName+"| Position: "+c.position+"| Skill: "+c.skill+"| Value: "+c.transferValue);
        }
        System.out.println(agency.size());
        return agency;
    }

public void setName(String name){
        this.name = name;
}

    public String getName() {
        return name;
    }
}

