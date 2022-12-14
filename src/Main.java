public class Main
{
    public static void main(String[] args) {
        ClientPool pool = new ClientPool();

        //pool.initializeClientPool();
        pool.addNewClient();
        pool.initializeClientPoolToCsv();

    }
}
