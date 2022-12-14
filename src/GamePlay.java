import java.util.ArrayList;
import java.util.Random;

public class GamePlay {
    String RESET = "\033[0m", GREEN_BOLD = "\033[1;32m", REDB = "\033[1;31m", YELB = "\033[1;33m", B_B= "\033[1;34m";
    Bank b = new Bank();
    ClientPool cp = new ClientPool();
    Clients c = new Clients("", "", "", 0, 0, 0, 0, 0);
    Agency a = new Agency("");
    TextUI ui = new TextUI();
    Negotiation neg = new ClientNegotiation();

    public void newTurn(){

        ui.displayMessage("How do you wish to proceed?");
        int input = Integer.parseInt(ui.getUserInput("Press 1 for clientpool" + "\n Press 2 to get a list of potential new clients" + "\n Press 3 enter your agency" + "\n Press 4 to simulate a year forward"));

        if (input == 1) {
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
            if (input == 2) {
                newTurn();
            }

        } else if (input == 2) {
            cp.displayClientList();
            chooseClient();
            newTurn();

        }


          else if(input == 3){
              input = Integer.parseInt(ui.getUserInput("Welcome to: " + a.getName() + "\n Press 1 to display your balance " + "\n Press 2 to upgrade agency" + "\n Press 3 for menu"));
              if (input == 1) {
                  b.displayBalance();
                  newTurn();
              }
              if (input == 2){
                 ui.displayMessage("Your current level is: " + a.getBureauLevel());
                 a.upgradeAgency();
                 ui.displayMessage("Your new agency level is: " + a.getBureauLevel());
                  newTurn();
              }
              if (input == 3){
                  a.getPortFolio();
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
        ArrayList<Clients> portfolio = cp.getClientList();
        for (Clients c : pool) {
            c.setAge(c.age + 1);
        }
        for (Clients c : portfolio) {
            c.setAge(c.age + 1);
        }
    }
    public void skillUpgrade() {
        Random rand = new Random();
        int upperLimit;
        int lowerLimit;
        ArrayList<Clients> pool = cp.getClientPool();
        ArrayList<Clients> portfolio = cp.getClientList();
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

     for (Clients c : portfolio) {
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
        int totalTaxes = b.withdrawMoney((totalSalary / 100) * 15);
        System.out.println("You've made " + totalSalary + " this year and paid " + totalTaxes + " in taxes");
    }

    public void chooseClient() {
        int input = Integer.parseInt(ui.getUserInput("Type in ID on the player you want to negotiate with"));
        for (Clients c : cp.getClientList()) {
            if (c.id == input) {
                //ui.displayMessage("ID: " + c.id + "Name: " + c.firstName + " " + c.lastName + "| Position: " + c.position + "Skill: " + c.skill + "Value: " + c.transferValue);
                neg.runNegotiation(c);
            }

        }

    }
}
