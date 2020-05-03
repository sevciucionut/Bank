package helper;

import contracts.BancaHelper;
import models.BancaImplements;
import models.Client;
import models.Credit;

import java.util.ArrayList;
import java.util.List;

public class Helper extends BancaHelper {
    @Override
    public BancaImplements construiesteDouaCredite() {


        List<Client> clients = new ArrayList<>();

        Client client1 = new Client();
        clients.add(client1);
        clients.get(0).setNume("Sevciuc");
        clients.get(0).setPrenume("Ionut");

        Credit credit1 = new Credit(3000, 0.15);
        clients.get(0).adaugaCredit(credit1, 15);

        Credit credit2 = new Credit(8000, 0.05);
        clients.get(0).adaugaCredit(credit2, 24);

        Client client2 = new Client("Anghel", "Costi");
        clients.add(client2);

        Credit credit3 = new Credit(12000, 0.1);
        clients.get(1).adaugaCredit(credit3, 48);


        return new BancaImplements(
                "BCR",
                "Bucale",
                clients);
    }
}
