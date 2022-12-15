import java.util.ArrayList;
import java.util.Random;

public class GamePlay {
    String RESET = "\033[0m", GREEN_BOLD = "\033[1;32m", REDB = "\033[1;31m", YELB = "\033[1;33m", B_B= "\033[1;34m";
    Bank b = new Bank();
    ClientPool cp = new ClientPool();
    Clients c = new Clients("", "", "", 0, 0, 0, 0, 0);
    Agency a = new Agency("");
    TextUI textUI = new TextUI();
    Negotiation neg = new ClientNegotiation();

    public void newTurn(){

        textUI.displayMessage("How do you wish to proceed?");
        int input = Integer.parseInt(textUI.getUserInput("Press 1 for clientpool" + "\nPress 2 to get a list of potential new clients" + "\nPress 3 enter your agency" + "\nloPress 4 to simulate a year forward"));

        if (input == 1) {
            a.getPortFolio();
            input = Integer.parseInt(textUI.getUserInput("Press 1 to remove a client" + "\nPress 2 for menu"));
            if (input == 1) {
                input = Integer.parseInt(textUI.getUserInput("Type in ID on the player you want to remove"));
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
            textUI.displayMessage("LIST OF AVAILABLE PLAYERS: ");
            cp.displayClientList();
            chooseClient();
            newTurn();
        }


          else if(input == 3){
              input = Integer.parseInt(textUI.getUserInput("Welcome to: " + a.getName() + "\n Press 1 to display your balance " + "\n Press 2 to upgrade agency" + "\n Press 3 for menu"));
              if (input == 1) {
                  b.displayBalance();
                  newTurn();
              }
              if (input == 2){
                 textUI.displayMessage("Your current level is: " + a.getBureauLevel() + "\n");
                 a.upgradeAgency();
                 textUI.displayMessage("Your new agency level is: " + a.getBureauLevel() + "\n");
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
        for (Clients c : pool) {
            c.setAge(c.age + 1);
        }
    }
    public void skillUpgrade() {
        System.out.println("NEXT TURNNNNNN");
        Random rand = new Random();
        int upperLimit;
        int lowerLimit;
        ArrayList<Clients> pool = cp.getClientPool();
        System.out.println("POOOOOOOOOOOOOOOOOL " + pool.get(0).getSkill() + pool.get(0).potential);
        // Vores agency-player liste mangler her - de bliver ikke opdatereset efter hver omgang.
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
        for (Clients c : a.getPortFolio())
        {
            double salaryPercentage = (c.transferValue / 10);
            int salary = (int) Math.round(salaryPercentage);
            totalSalary += salary;
        }
    b.displayBalance();
        b.addMoney(totalSalary);
        b.displayBalance();
        int totalTaxes = b.taxes(totalSalary);
        b.withdrawMoney(totalTaxes);
        System.out.println("You've made " + totalSalary + " this year and paid " + totalTaxes + " in taxes");
    }

    public void chooseClient() {
        ArrayList<Clients> clientList = cp.displayClientList();

        for (Clients c: clientList)
        {
            System.out.println("ID: " + c.id +"\nName: " + c.firstName + " " + c.lastName + " Age: " + c.age + " | Position: "+c.position+"| Skill: "+c.skill+"| Value: "+c.transferValue +"\n");
        }

        int input = Integer.parseInt(textUI.getUserInput("Type in ID on the player you want to negotiate with"));

        for (Clients c : clientList)
        {
            if (c.id == input) {
                textUI.displayMessage("\nYou are now in negotiations with: " + "\n" +c.firstName + " " + c.lastName + "\nAge: " + c.age + "\nPosition: "+c.position+"\nSkill: "+c.skill+"\nValue: "+c.transferValue +"\n");
                neg.runNegotiation(c);
            }

        }

    }
}
