package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Client {
    private String nume;
    private String prenume;
    private Credit[] creditDePlata = new Credit[0];
    private Rata[] rata = new Rata[0];

    public Client() {
    }

    public Client(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    public Client(String nume, String prenume, Credit[] creditDePlata) {
        this.nume = nume;
        this.prenume = prenume;
        this.creditDePlata = creditDePlata;
        for (Credit credit : this.creditDePlata) {
            Rata[] aux = new Rata[this.creditDePlata.length + 1];
            aux[this.creditDePlata.length] = new Rata(credit, 5);
            for (int i = 0; i < this.rata.length; i++) {
                aux[i] = this.rata[i];
            }
            this.rata = aux;
        }
    }

    public Client(String nume, String prenume, Credit[] creditDePlata, int nrRate) {
        this.nume = nume;
        this.prenume = prenume;
        this.creditDePlata = creditDePlata;
        for (Credit credit : this.creditDePlata) {
            Rata[] aux = new Rata[this.rata.length + 1];
            aux[this.rata.length] = new Rata(credit, nrRate);
            for (int i = 0; i < this.rata.length; i++) {
                aux[i] = this.rata[i];
            }
            this.rata = aux;
        }
    }

    public Client(String nume, String prenume, Credit creditDePlata) {
        this.nume = nume;
        this.prenume = prenume;

        Credit[] aux = new Credit[1];
        aux[0] = creditDePlata;
        this.creditDePlata = aux;

        Rata[] auxRata = new Rata[1];
        auxRata[0] = new Rata(creditDePlata, 5);
        this.rata = auxRata;
    }

    public Client(String nume, String prenume, Credit creditDePlata, int nrRate) {
        this.nume = nume;
        this.prenume = prenume;

        Credit[] aux = new Credit[1];
        aux[0] = creditDePlata;
        this.creditDePlata = aux;

        Rata[] auxRata = new Rata[1];
        auxRata[0] = new Rata(creditDePlata, nrRate);
        this.rata = auxRata;
    }

    public void adaugaCredit(Credit credit) {
        Credit[] aux = new Credit[this.creditDePlata.length + 1];
        aux[this.creditDePlata.length] = credit;
        for (int i = 0; i < this.creditDePlata.length; i++) {
            aux[i] = this.creditDePlata[i];
        }
        this.creditDePlata = aux;

        Rata[] auxRata = new Rata[this.rata.length + 1];
        auxRata[this.rata.length] = new Rata(credit, 5);
        for (int i = 0; i < this.rata.length; i++) {
            auxRata[i] = this.rata[i];
        }
        this.rata = auxRata;
    }

    public void adaugaCredit(Credit credit, int nrRate) {
        Credit[] aux = new Credit[this.creditDePlata.length + 1];
        aux[this.creditDePlata.length] = credit;
        for (int i = 0; i < this.creditDePlata.length; i++) {
            aux[i] = this.creditDePlata[i];
        }
        this.creditDePlata = aux;

        Rata[] auxRata = new Rata[this.rata.length + 1];
        auxRata[this.rata.length] = new Rata(credit, nrRate);
        for (int i = 0; i < this.rata.length; i++) {
            auxRata[i] = this.rata[i];
        }
        this.rata = auxRata;
    }

    public void stergeCredit(int nrCredit) {
        int nr = 0;
        Credit[] aux = new Credit[this.creditDePlata.length - 1];
        for (int i = 0; i < this.creditDePlata.length ; i++) {
            if (i != nrCredit) {
                aux[nr] = this.creditDePlata[i];
                nr++;
            }
        }
        this.creditDePlata = aux;

        nr = 0;
        Rata[] auxRata = new Rata[this.rata.length - 1];
        for (int i = 0; i < this.rata.length; i++) {
            if (i != nrCredit){
                auxRata[nr] = this.rata[i];
                nr++;
            }
        }
        this.rata = auxRata;

    }

    public Rata[] getRata() {
        return rata;
    }

    public void setCreditDePlata(Credit[] creditDePlata) {
        this.creditDePlata = creditDePlata;
    }

    public void setCreditDePlata(Credit creditDePlata) {
        Credit[] aux = new Credit[1];
        aux[0] = creditDePlata;
        this.creditDePlata = aux;
    }

    public Credit[] getCreditDePlata() {
        return creditDePlata;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public static Comparator<Client> alfabetic = new Comparator<Client>() {
        @Override
        public int compare(Client o1, Client o2) {
            String a = o1.nume;
            String b = o2.nume;
            return a.compareTo(b);
        }
    };

    @Override
    public String toString() {
        return "Client{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", creditDePlata=" + Arrays.toString(creditDePlata) +
                ", rata=" + Arrays.toString(rata) +
                '}';
    }
}
