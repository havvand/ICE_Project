import java.sql.Array;

public class Agency  {

    int bureauLevel;

    Clients [] portfolio1;
    Clients [] portfolio2;
    Clients [] portfolio3;

    public void makePortfolio(Clients [] portfolio){
        for (Clients c:portfolio) {
            makePortfolio(portfolio);
        }
    }



    public int getBureauLevel() {
        return bureauLevel;
    }
    }

