import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class Clients {
    String firstName, lastName, position;
    int age, skill, potential, transferValue;

    public Clients(String firstName, String lastName, String position, int age, int skill, int potential, int transferValue) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.age = age;
        this.skill = skill;
        this.potential = potential;
        this.transferValue = transferValue;
    }


        public Clients newClient ()
        {
            return new Clients("Ole", "Jensen", "top", 22, 44, 3, 1000000);
        }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getAge() {
        return age;
    }

    public int getPotential() {
        return potential;
    }

    public int getSkill() {
        return skill;
    }

    public int getTransferValue() {
        return transferValue;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public String toString ()
        {
            return this.firstName;
        }

}
