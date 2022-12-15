import java.util.ArrayList;
import java.util.Random;

public class GamePlay {
    String RESET = "\033[0m", GREEN_BOLD = "\033[1;32m", REDB = "\033[1;31m", YELB = "\033[1;33m", B_B= "\033[1;34m";
    Bank b = new Bank();
    ClientPool cp = new ClientPool();
    Clients c = new Clients("","","",0,0,0,0, 0);

    public void newTurn(){

        ui.displayMessage("How do you wish to proceed?");
       int input = Integer.parseInt(ui.getUserInput("Press 1 for clientpool" + "\n Press 2 to get a list of potential new clients" + "\n Press 3 enter your agency" + "\n Press 4 to simulate a year forward"));

       if (input == 1){
           a.getPortFolio();
           input = Integer.parseInt(ui.getUserInput("Press 1 to remove a client" + "\n Press 2 for menu"));
           if (input == 1) {
               input = Integer.parseInt(ui.getUserInput("Type in ID on the player you want to remove"));
               for (Clients c : a.getPortFolio()) {
                   if (c.id == input) {
                       a.removeClientFromAgency(c);
                       newTurn();
                   }
               }
           }
           if (input == 2){
               newTurn();
           }

       }
           else if (input == 2){
               //cp.getPotentialNewClients;
               nextTurn();

           }

          else if(input == 3){
              ui.getUserInput("Welcome to: " + a.getName() + "\n Press 1 to display your balance " + "\n Press 2 to upgrade agency" + "\n Press 3 for menu");
              if (input == 1) {
                  b.displayBalance();
                  newTurn();
              }
              if (input == 2){
                 ui.displayMessage("Your current level is: " + a.getBureauLevel());
                 a.upgradeAgency();
                  newTurn();
              }
              if (input == 3){
                  newTurn();
              }
           }
          else if (input == 4){
              nextTurn();
       }

    }
    public void nextTurn(){
        clientSalary();
        aging();
        skillUpgrade();
        newTurn();
    }

    public void aging(){
        ArrayList<Clients> pool = cp.getClientPool();
        for (Clients c : pool) {
            c.setAge(c.age + 1);
        }
    }
    public void skillUpgrade() {
        Random rand = new Random();
        int upperLimit;
        int lowerLimit;
        ArrayList<Clients> pool = cp.getClientPool();
        for (Clients c : pool) {
            if (c.age > 30)

            if (c.potential > 25 && c.potential <= 35) {

                int randInt = rand.nextInt(1) + 1;
                c.setSkill(c.skill + randInt);

                if (c.skill > c.potential) {
                    c.skill = c.potential;
                }

            } else if (c.potential > 35 && c.potential <= 50) {

                lowerLimit = 2;
                upperLimit = 4;
                int randInt = rand.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                c.setSkill(c.skill + randInt);
                if (c.skill > c.potential) {
                    c.skill = c.potential;
                }
            } else if (c.potential > 50 && c.potential <= 65) {

                lowerLimit = 3;
                upperLimit = 6;
                int randInt = rand.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                c.setSkill(c.skill + randInt);
                if (c.skill > c.potential) {
                    c.skill = c.potential;
                }
            } else if (c.potential > 65 && c.potential <= 80) {

                lowerLimit = 5;
                upperLimit = 8;
                int randInt = rand.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                c.setSkill(c.skill + randInt);
                if (c.skill > c.potential) {
                    c.skill = c.potential;
                }
            } else if (c.potential > 80 && c.potential <= 100) {

                lowerLimit = 7;
                upperLimit = 10;
                int randInt = rand.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                c.setSkill(c.skill + randInt);
                if (c.skill > c.potential) {
                    c.skill = c.potential;
                }
            }
        }
    }

public void clientSalary(){
int totalSalary = 0;
        for (Clients c : a.getPortFolio()){
            double salaryPercentage = (c.transferValue / 10);
            int salary = (int) Math.round(salaryPercentage);
            totalSalary += salary;
        }
    b.addMoney(totalSalary);
    b.withdrawMoney((totalSalary/100)*15);
}

}
