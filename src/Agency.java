import java.util.ArrayList;

public class Agency {
   static String name;
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
        System.out.println("You have upgraded your agency");

    }

    public ArrayList<Clients> getPortFolio() {
        System.out.println("\n");
        for (Clients c: agency) {
            System.out.println("ID: " + c.id+" Name: "+ c.firstName+" "+c.lastName+" " + "Age: " + c.age + "| Position: "+c.position+"| Skill: "+c.skill+"| Value: "+c.transferValue);
        }
        System.out.println("You have: " + agency.size() + " Client(s) in your portfolio");
        return agency;
    }
public void setName(String name){
        this.name = name;
}

    public String getName() {
        return name;
    }
}

