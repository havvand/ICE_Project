import java.util.ArrayList;
import java.util.Random;

public class GamePlay {
    String RESET = "\033[0m", GREEN_BOLD = "\033[1;32m", REDB = "\033[1;31m", YELB = "\033[1;33m", B_B= "\033[1;34m";
    Bank b = new Bank();
    ClientPool cp = new ClientPool();
    Clients c = new Clients("","","",0,0,0,0, 0);
    Agency a = new Agency();
    public void nextTurn(){
        Random rand = new Random();
        int upperLimit;
        int lowerLimit;
        ArrayList<Clients> pool = cp.getClientPool();
            for (Clients c : pool){
            c.setAge(c.age +1);

           // if (c.age < 20) {

                if (c.potential > 25 && c.potential <= 35) {

                        int randInt = rand.nextInt(1) + 1;
                        c.setSkill(c.skill + randInt);

                        if (c.skill > c.potential){
                            c.skill = c.potential;
                        }

                } else if (c.potential > 35 && c.potential <= 50) {

                        lowerLimit = 2;
                        upperLimit = 4;
                        int randInt = rand.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                        c.setSkill(c.skill + randInt);
                    if (c.skill > c.potential){
                        c.skill = c.potential;
                    }
                } else if (c.potential > 50 && c.potential <= 65) {

                        lowerLimit = 3;
                        upperLimit = 6;
                        int randInt = rand.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                        c.setSkill(c.skill + randInt);
                    if (c.skill > c.potential){
                        c.skill = c.potential;
                    }
                } else if (c.potential > 65 && c.potential <= 80) {

                        lowerLimit = 5;
                        upperLimit = 8;
                        int randInt = rand.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                        c.setSkill(c.skill + randInt);
                    if (c.skill > c.potential){
                        c.skill = c.potential;
                    }
                } else if (c.potential > 80 && c.potential <= 100) {

                        lowerLimit = 7;
                        upperLimit = 10;
                        int randInt = rand.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                        c.setSkill(c.skill + randInt);
                    if (c.skill > c.potential){
                        c.skill = c.potential;
                    }
                }



            }


}
public void clientSalary(){
int totalSalary = 0;
        for (Clients c : a.getPortfolio()){
            double salaryPercentage = (c.transferValue / 10);
            int salary = (int) Math.round(salaryPercentage);
            totalSalary += salary;
        }
    b.addMoney(totalSalary);
    b.withdrawMoney((totalSalary/100)*15);
}
}
