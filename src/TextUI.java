import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
    static Scanner scan = new Scanner(System.in);

    public String repeatString(int i, String s) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++)
            sb.append(s);
        return sb.toString();
    }

    public void displayMessage(String msg) {
        int stringNoSpaces = msg.replace(" ", "").length();
        int stringLength = msg.length() - (msg.length() - stringNoSpaces);
        String dash = "-";
        System.out.println(repeatString(stringLength, dash));
        System.out.println(msg);
        System.out.println(repeatString(stringLength, dash) );

    }
    public void printArray(ArrayList<String> objects) {
        int i = 1;
        for (String a : objects)
        {
            System.out.println(a + "\n");
            i++;
        }
    }

    public String getUserInput(String msg) {
        this.displayMessage(msg);
        return scan.nextLine();
    }
    public int getUserInputNum(String msg) {
        this.displayMessage(msg);
        return Integer.parseInt(scan.nextLine());
    }

}
