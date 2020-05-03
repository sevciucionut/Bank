package contracts;

import models.Client;
import models.Credit;

public interface Banca {

    void adaugaClient(Client client);
    void stergeClient(int index);
    void adaugaCredit(int indexClient, Credit credit, int nrRate);
    void editareNumarRatePlatite(int indexClient, int nr, int nrCredit);
    void afsareClienti();
    void afisareaUnuiClient(int index);

}
