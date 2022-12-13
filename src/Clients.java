import java.util.Random;
public class Clients

{
    String firstName, lastName, position;
    int age, skill, potential, transferValue;

    public Clients(String firstName, String lastName, String position, int age, int skill, int potential, int transferValue)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.age = age;
        this.skill = skill;
        this.potential = potential;
        this.transferValue = transferValue;
    }

    public void nextTurn(){
        Random rand = new Random();

        age = age + 1;
        if (potential >25 && potential <= 35){
            int randInt = rand.nextInt(1)+1;
            potential = potential + randInt;
        } else if (potential >35 && potential <= 50) {
            int randInt = rand.nextInt(5)+1;
            potential = potential + randInt;
        } else if (potential > 50 && potential <=65) {
            int randInt = rand.nextInt(8)+1;
            potential = potential + randInt;
        } else if (potential > 65 && potential <= 80) {
            int randInt = rand.nextInt(10)+1;
            potential = potential + randInt;
        } else if (potential > 80 && potential <=100) {
            int randInt = rand.nextInt(13)+1;
            potential = potential + randInt;
        }
    }
    public Clients newClient()
    {
        return new Clients("Ole", "Jensen", "top", 22, 44, 3, 1000000);
    }

    public String toString()
    {
        return this.firstName;
    }
}
