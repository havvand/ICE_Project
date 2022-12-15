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

    }
}
