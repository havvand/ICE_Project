import java.util.Scanner;

public class ClientNegotiation implements Negotiation {
    private int agentOffer;
    private int clientResistancePoint;
    private int negCount = 0;
    private final Bank bank = new Bank();
    private final TextUI textUI = new TextUI();
    private Clients client = new Clients("","","",0,0,0,0, 0);
    private final Agency agency = new Agency("");
    private final ClientPool cp = new ClientPool();

    public void runNegotiation(Clients c) {
        resistancePointSetter(c);
        if (negCount == 0){
        //give initial offer
        agentOffer = textUI.getUserInputNum("Make initial offer for client");
            if(agentOffer >= clientResistancePoint) {
                System.out.println("I am in!");
                acceptOffer(c);
            }
        // check if we're within clients range
        if(agentOffer < clientResistancePoint) {
            //offer is declined
            ++negCount;
        }}
        if(negCount == 1){
            System.out.println("Are you kidding me?");
            agentOffer = textUI.getUserInputNum("You can do better than that");
            if(agentOffer >= clientResistancePoint) {
                System.out.println("I am in!");
                acceptOffer(c);
            }
            else{
                ++negCount;
                System.out.println("Hmm.. Nah!");
            }
        }
        if (negCount == 2){
            System.out.println("Come on man");
            agentOffer = textUI.getUserInputNum("Last try you...");
            if(agentOffer >= clientResistancePoint) {
                System.out.println("I am in!");
                acceptOffer(c);

        }
            else {
                System.out.println(client.getFirstName()+" "+client.getLastName()+" has left the negotiation without a deal");
                declineOffer(c);
            }
        // leave negotiation and return to player list
    }
    }
     public void improvedOffer() {
         //improve offer on decline
         agentOffer = textUI.getUserInputNum("You can do better than that");
         ++negCount;
     }
     public int resistancePointSetter(Clients c) {
        this.client = c;
         // resistancePoint is set to skill * 1 mil / 10 which is 10% of their transfervalue
         clientResistancePoint = client.getTransferValue() / 10;
        //returns the resistancePoint for the client by
         //if the ability is above a certain
         System.out.println(clientResistancePoint);
        return clientResistancePoint;
     }

    @Override
    public void acceptOffer(Clients c) {
        this.client = c;
        agency.addClientToAgency(c);
        bank.withdrawMoney(agentOffer);
        cp.removeClientFromPool(c.id);
        //return to clientPool;

    }

    @Override
    public void declineOffer(Clients c) {
        cp.removeClientFromPool(c.id);
        //return to clientPool;

    }

}
