import java.util.ArrayList;
import java.util.Random;

public class GamePlay {
    FileIO io = new FileIO();
    Clients client = new Clients("","","",0,0,0,0, 0);
    public void nextTurn(){
        Random rand = new Random();
        int upperLimit;
        int lowerLimit;
        ArrayList<String> pool = io.getClientPool();

        while (pool.listIterator().hasNext()) {
            client.setAge(client.getAge() +1);


            if (client.getPotential() > 25 && client.getPotential() <= 35) {
                if (client.getSkill()<35) {
                    int randInt = rand.nextInt(1) + 1;
                    client.setSkill(client.getSkill() + randInt);


                }
            } else if (client.getPotential() > 35 && client.getPotential() <= 50) {
                if (client.getSkill() < 50) {
                    lowerLimit = 2;
                    upperLimit = 4;
                    int randInt = rand.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                    client.setSkill(client.getSkill() + randInt);
                }
            } else if (client.getPotential() > 50 && client.getPotential() <= 65) {
                if (client.getSkill() < 65) {
                    lowerLimit = 3;
                    upperLimit = 6;
                    int randInt = rand.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                    client.setSkill(client.getSkill() + randInt);
                }
            } else if (client.getPotential() > 65 && client.getPotential() <= 80) {
                if (client.getSkill() < 80) {
                    lowerLimit = 5;
                    upperLimit = 8;
                    int randInt = rand.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                    client.setSkill(client.getSkill() + randInt);
                }
            } else if (client.getPotential() > 80 && client.getPotential() <= 100) {
                if (client.getSkill()<95) {
                    lowerLimit = 7;
                    upperLimit = 10;
                    int randInt = rand.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                    client.setSkill(client.getSkill() + randInt);
                }
            }
        }
    }

}
