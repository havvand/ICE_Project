public class Main {
    public static void main(String[] args) {

        GamePlay gp = new GamePlay();
        ClientPool cp = new ClientPool();
        FileIO io = new FileIO();


        cp.initializeArrayList();
        cp.displayClientList();


    }
}

