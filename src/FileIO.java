import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class FileIO {
    public String getAFirstName() {
        Random rand = new Random();
        int randomint = rand.nextInt(100) + 1;
        ArrayList<String> firstNameList = new ArrayList<>();

        try {
            FileReader names = new FileReader("data/names.csv");
            Scanner reader = new Scanner(names);
            while (reader.hasNextLine()) {
                String s = reader.nextLine();
                String[] userData = s.split(";");
                String firstName = userData[0];
                String lastName = userData[1];

                firstNameList.add(firstName);


            }
        } catch (FileNotFoundException e) {
            System.out.println("Datafile not found");
            //userData = null;
        }
        return firstNameList.get(randomint);
    }

    public String getALastName() {
        Random rand = new Random();
        int randomint = rand.nextInt(100) + 1;
        ArrayList<String> lastNameList = new ArrayList<>();

        try {
            FileReader names = new FileReader("data/names.csv");
            Scanner reader = new Scanner(names);
            while (reader.hasNextLine()) {
                String s = reader.nextLine();
                String[] userData = s.split(";");
                String lastName = userData[1];
                String char1 = lastName.substring(0,1);
                String theRest = lastName.substring(1).toLowerCase();
                lastName= char1 + theRest;

                lastNameList.add(lastName);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Datafile not found");
            //userData = null;
        }
        System.out.println(lastNameList.get(randomint));
        return lastNameList.get(randomint);
    }

    public ArrayList<String> initiateClubs() {
        ArrayList<String> clubNationTier = new ArrayList<>();
        try {

            FileReader names = new FileReader("data/Klubnavne.csv");
            Scanner reader = new Scanner(names);
            reader.nextLine();

            while (reader.hasNextLine()) {
                String s = reader.nextLine();
                String[] clubData = s.split(";");
                String clubName = clubData[1];
                String nation = clubData[2];
                String tier = clubData[3];

                clubNationTier.add(clubName);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Datafile not found");
            //userData = null;
        }
        System.out.println(clubNationTier);
        return clubNationTier;
    }

}
