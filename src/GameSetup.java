import java.util.ArrayList;
import java.util.Random;

public class GameSetup
{
    TextUI ui = new TextUI();
    Agency a = new Agency("");
    GamePlay gp = new GamePlay();
    Bank b = new Bank();
    public void mainMenu() {
        b.setStartAmount();
        ui.displayMessage("Welcome to Football Agent - The Game!");
        String input = ui.getUserInput("Please enter the name of your Agency");
        a.setName(input);
        System.out.println(a.getName());
        ui.displayMessage("Game starting:");
        gp.newTurn();

        //input choice
        /* 1. Clients
        Shows the list of clients - if you dont have any it will send you to option 2.?
        should have a remove client option, upgrade agency and perhaps display your balance
        * 2. Get new client
        choose the client you want to negotiate with
        * 3. Show my balance
         4. Next turn  */
    }
}
