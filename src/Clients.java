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

    public Clients newClient()
    {
        return new Clients("Ole", "Jensen", "top", 22, 44, 3, 1000000);
    }

    public String toString()
    {
        return this.firstName;
    }
}
