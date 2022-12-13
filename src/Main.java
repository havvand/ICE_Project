import java.util.Random;

public class Main
{
    public static void main(String[] args) {
        int hej = 10;
        ClientPool pool = new ClientPool();
        TextUI ui = new TextUI();
        FileIO io = new FileIO();
        Random rand = new Random();
        System.out.println(hej);
        int randomInt = rand.nextInt(100,)+1;
        hej = hej + randomInt;
        System.out.println(randomInt);
        System.out.println(hej);




      //io.getAFirstName();
      //ui.printArray(io.initiateClubs());
       // io.getAFirstName();
    //  ui.printArray(io.firstNameList);


    }
}
