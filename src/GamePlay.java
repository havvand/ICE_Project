import java.util.ArrayList;
import java.util.Random;

public class GamePlay {
    ClientPool cp = new ClientPool();
    Clients c = new Clients("","","",0,0,0,0, 0);
    public void nextTurn(){
        Random rand = new Random();
        int upperLimit;
        int lowerLimit;
        ArrayList<Clients> pool = cp.getClientPool();
        System.out.println("first name: " + cp.getClientPool().get(0).firstName);
        System.out.println("skill level: " + cp.getClientPool().get(0).skill);
        System.out.println("potential: " + cp.getClientPool().get(0).potential);
        System.out.println("age: " + cp.getClientPool().get(0).age);





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
        System.out.println("first name: " + cp.getClientPool().get(0).firstName);
        System.out.println("skill level: " + cp.getClientPool().get(0).skill);
        System.out.println("potential: " + cp.getClientPool().get(0).potential);
        System.out.println("age: " + cp.getClientPool().get(0).age);
}
}
