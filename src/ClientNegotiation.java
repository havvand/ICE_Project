import java.util.Scanner;

public class ClientNegotiation implements Negotiation {
    private int agentOffer;
    private int agentTargetPoint;
    private int agentResistancePoint;
    private int clientTargetPoint;
    private int clientResistancePoint;
    private int negCount = 0;
    private final Bank bank = new Bank();
    private final TextUI textUI = new TextUI();

    private final Scanner scanner = new Scanner(System.in);

    public void negotiationRounds() {
        resistancePointSetter();
        //give initial offer
        agentResistancePoint = textUI.getUserInputNum("How much are you willing to pay from this client?");
        agentOffer = textUI.getUserInputNum("Make initial offer for client");
        // check if we're within clients range
        if(agentOffer < clientResistancePoint) {
            System.out.println("Are you kidding me?");
            //offer is declined
            ++negCount;
            improvedOffer();
        }
        if(agentOffer >= clientResistancePoint) {
            System.out.println("Wow! I am in!");
            acceptOffer();
        }
        if(negCount > 3) {
            System.out.println("client.getName+ has left the negotiating table without a deal");
            declineOffer();
        }
        //accept or decline
        /* run acceptOffer() or declineOffer() and then iterate over offer*/
        //improve offer on decline ap
        /* input = new offer */
        //accept or decline until max iteration
        /* leave negotiation and return to player list */
    }
     public void improvedOffer() {
         agentOffer = textUI.getUserInputNum("You can do better than that");
         ++negCount;
     }
     public int resistancePointSetter() {
        //Client client = new Client
         // resistancePoint is set to skill * 1 mil / 10 which is 10% of their transfervalue
         //clientResistancePoint = client.transferValue / 10;
        //returns the resistancePoint for the client by
         //if the ability is above a certain
        return clientResistancePoint;
     }
     /* public int targetPointSetter() {
        //returns the targetPoint for the client by
        return clientTargetPoint;
     }

     public void negotiationType() {
        //based on certain attribute from player a difficulty is set for the negotiations
        // three different forms of negotiations are present:
        // 1. The tough type (not willing to budge on what they want)
        // 2. Compromise (more amicable towards finding something that serves both parties)
        // 3. The weak type (typically accepts within initial or second offer
    }*/

    @Override
    public void acceptOffer() {
        addClientToAgency();
        bank.withdrawMoney(agentOffer);
        //return to clientPool;

    }

    @Override
    public void declineOffer() {
        removeClientFromPool();
        //return to clientPool;

    }

    @Override
    public void addClientToAgency() {
        //adds the prospective client to AgentBureau
        /* Agency agency = new Agency;
        *  agency.add(client); */



    }

    @Override
    public void removeClientFromPool() {
        //removes client from clientPool
        /* ClientPool cp = new ClientPool
        * cp.remove(client); */
    }
}
