import java.util.ArrayList;

public class Agency {
    private int bureauLevel;
    private ArrayList<Clients> agency = new ArrayList<>();
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

    }

    public ArrayList<Clients> getPortFolio() {
        return agency;
    }

    }

