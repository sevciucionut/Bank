package models;

import contracts.Banca;

import java.util.ArrayList;
import java.util.List;

public class BancaImplements implements Banca {

    private String numeBanca;
    private String locatieBanca;

    private List<Client> clienti = new ArrayList<>();

    public BancaImplements(String numeBanca, String locatieBanca, List<Client> clienti) {
        this.numeBanca = numeBanca;
        this.locatieBanca = locatieBanca;
        this.clienti = clienti;
    }
    public BancaImplements(String numeBanca, String locatieBanca, Client clienti) {
        this.numeBanca = numeBanca;
        this.locatieBanca = locatieBanca;
        this.clienti.add(clienti);
    }

    public BancaImplements(String numeBanca, String locatieBanca) {
        this.numeBanca = numeBanca;
        this.locatieBanca = locatieBanca;
    }

    public String getNumeBanca() {
        return numeBanca;
    }

    public String getLocatieBanca() {
        return locatieBanca;
    }

    public List<Client> getClienti() {
        return clienti;
    }

    @Override
    public void adaugaClient(Client client) {
        this.clienti.add(client);
        System.out.println("<<<<<<<<<<<A fost adaugat un client>>>>>>>>>>");
        afisareaUnuiClient(clienti.size()-1);
    }

    @Override
    public void stergeClient(int index) {
        System.out.println("<<<<<<<<<<Sa sters un client>>>>>>>>>>");
        afisareaUnuiClient(index);
        this.clienti.remove(index);

    }

    @Override
    public void adaugaCredit(int indexClient, Credit credit, int nrRate) {
        System.out.println("<<<<<<<<<<Clientul " + clienti.get(indexClient).getNume() + " " + clienti.get(indexClient).getPrenume() +
                " si-a adaugat creditul: " + credit + ">>>>>>>>>>");
        this.clienti.get(indexClient).adaugaCredit(credit, nrRate);
        afisareaUnuiClient(indexClient);
    }

    @Override
    public void editareNumarRatePlatite(int indexClient, int nr, int nrCredit) {
        System.out.println("<<<<<<<<<<Clientul " + clienti.get(indexClient).getNume() + " " + clienti.get(indexClient).getPrenume() +
                " a platit " + nr + " rate>>>>>>>>>>");
        clienti.get(indexClient).getRata()[nrCredit].setNrRatePlatite(nr);
        if (clienti.get(indexClient).getRata()[nrCredit].getNrRatePlatite() >= clienti.get(indexClient).getRata()[nrCredit].getNrRate()) {
            System.out.println("<<<<<<<<<<Clientul " + clienti.get(indexClient).getNume() + " " + clienti.get(indexClient).getPrenume() +
                    " a platit toata rata>>>>>>>>>>");
            clienti.get(indexClient).stergeCredit(nrCredit);
        }
        afisareaUnuiClient(indexClient);
    }

    @Override
    public void afsareClienti() {
        for (int i = 0; i < this.clienti.size(); i++) {
            System.out.println("\n" + this.clienti.get(i).getNume() + " " + this.clienti.get(i).getPrenume());
            for (int j = 0; j < this.clienti.get(i).getCreditDePlata().length; j++) {
                System.out.println("\nCreditul " + (j + 1));
                System.out.println("Suma extrasa este: " + this.clienti.get(i).getCreditDePlata()[j].suma +
                        "\nDobanda la acest credit este: " + this.clienti.get(i).getCreditDePlata()[j].dobanda +
                        "\nTotalul de plata este: " + this.clienti.get(i).getRata()[j].getTotalPlata() +
                        "\nRata este de " + this.clienti.get(i).getRata()[j].getRata() +
                        "\nNumarul de rate: " + this.clienti.get(i).getRata()[j].getNrRate() +
                        "\nNumarul de rate platite este: " + this.clienti.get(i).getRata()[j].getNrRatePlatite() +
                        "\nMai trebuie platit: " + this.clienti.get(i).getRata()[j].getRamasPlata());
            }
        }
    }

    @Override
    public void afisareaUnuiClient(int i) {
        System.out.println(this.clienti.get(i).getNume() + " " + this.clienti.get(i).getPrenume());
        for (int j = 0; j < this.clienti.get(i).getCreditDePlata().length; j++) {
            System.out.println("\nCreditul " + (j + 1));
            System.out.println("Suma extrasa este: " + this.clienti.get(i).getCreditDePlata()[j].suma +
                    "\nDobanda la acest credit este: " + this.clienti.get(i).getCreditDePlata()[j].dobanda +
                    "\nTotalul de plata este: " + this.clienti.get(i).getRata()[j].getTotalPlata() +
                    "\nRata este de " + this.clienti.get(i).getRata()[j].getRata() +
                    "\nNumarul de rate: " + this.clienti.get(i).getRata()[j].getNrRate() +
                    "\nNumarul de rate platite este: " + this.clienti.get(i).getRata()[j].getNrRatePlatite() +
                    "\nMai trebuie platit: " + this.clienti.get(i).getRata()[j].getRamasPlata() + "\n\n");
        }
    }


}
