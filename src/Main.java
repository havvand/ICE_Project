public class Main {
    public static void main(String[] args) {

        GameSetup gs = new GameSetup();
        ClientPool cp = new ClientPool();
        FileIO io = new FileIO();

        cp.initializeClientPool();
        cp.addToClientPoolTxt();
        io.getClientPool();
        //gs.nextTurn();
    }
}

