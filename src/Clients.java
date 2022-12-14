import java.util.Random;

public class Clients
{
    FileIO fileIo = new FileIO();
    // 50 goalies : 200 defenders : 200 midfield : 100 forwards.
    String firstName, lastName, position;
    int id, age, skill, potential, transferValue;

    public Clients(String firstName, String lastName, String position, int id, int age, int skill, int potential, int transferValue)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.id = id;
        this.age = age;
        this.skill = skill;
        this.potential = potential;
        this.transferValue = transferValue;
    }

    public Clients newClient(int type, int id)
    {
        potential = (int)(Math.random()*(100 - 25 + 1) + 25);
        age = (int)(Math.random()*(28 - 16 + 1) + 16);
        skill = (int)(Math.random()*(potential - 25 + 1) + 25);
        transferValue = (skill*1000000);

        if (type == 1)
        {
            String firstName = fileIo.getAFirstName();
            String lastName = fileIo.getALastName();

            return new Clients(firstName, lastName, "Goalkeeper", id, age, skill, potential, transferValue);
        }
        if (type == 2)
        {
            String firstName = fileIo.getAFirstName();
            String lastName = fileIo.getALastName();

            return new Clients(firstName, lastName, "Defender", id, age, skill, potential, transferValue);
        }
        if (type == 3)
        {
            String firstName = fileIo.getAFirstName();
            String lastName = fileIo.getALastName();

            return new Clients(firstName, lastName, "Midfield", id, age, skill, potential, transferValue);
        }
        if (type == 4)
        {
            String firstName = fileIo.getAFirstName();
            String lastName = fileIo.getALastName();

            return new Clients(firstName, lastName, "Forward", id, age, skill, potential, transferValue);
        }

        return null;
    }

    public String toString()
    {
        return "";
    }
}
