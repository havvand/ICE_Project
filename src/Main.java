public class Main
{
    public static void main(String[] args) {
        ClientPool pool = new ClientPool();
        GameSetup setup = new GameSetup();

        pool.initializeArrayList();
        pool.removeClientFromPool();

    }
}
