public class Main
{
    public static void main(String[] args) {
        ClientPool pool = new ClientPool();
        TextUI ui = new TextUI();
        FileIO io = new FileIO();

      io.getAFirstName();
       // io.getAFirstName();
      ui.printArray(io.firstNameList);


    }
}
