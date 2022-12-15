import java.util.ArrayList;
import java.util.Random;

public class GameSetup extends GamePlay
{
    TextUI ui = new TextUI();
    Agency a = new Agency("");
    GamePlay gp = new GamePlay();
    public void mainMenu() {
        ui.displayMessage("Welcome to Football Agent - The Game!");
        String input = ui.getUserInput("Please enter the name of your Agency");
        a.setName(input);
        System.out.println(a.getName());
        ui.displayMessage("Game starting:");
        gp.newTurn();

    }
}
