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
    private final Clients client = new Clients("","","",0,0,0,0, 0);
    private final Agency agency = new Agency("");
    private final ClientPool cp = new ClientPool();

    public void runNegotiation() {
        resistancePointSetter();
        //give initial offer
        agentOffer = textUI.getUserInputNum("Make initial offer for client");
        // check if we're within clients range
        if(agentOffer < clientResistancePoint) {
            System.out.println("Are you kidding me?");
            //offer is declined
            ++negCount;
            improvedOffer();
        }
        if(agentOffer >= clientResistancePoint) {
            System.out.println("I am in!");
            acceptOffer();
        }
        if(negCount > 3) {
            System.out.println(client.getFirstName()+" "+client.getLastName()+" has left the negotiation without a deal");
            declineOffer();
        }
        // leave negotiation and return to player list
    }
     public void improvedOffer() {
         //improve offer on decline
         agentOffer = textUI.getUserInputNum("You can do better than that");
         ++negCount;
     }
     public int resistancePointSetter() {

         // resistancePoint is set to skill * 1 mil / 10 which is 10% of their transfervalue
         clientResistancePoint = client.getTransferValue() / 10;
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
        agency.addClientToAgency(client);
        bank.withdrawMoney(agentOffer);
        cp.removeClientFromPool();
        //return to clientPool;

    }

    @Override
    public void declineOffer() {
        cp.removeClientFromPool();
        //return to clientPool;

    }

}
