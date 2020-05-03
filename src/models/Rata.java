package models;

public class Rata {
    private double rata;
    private int nrRate;
    private double totalPlata;
    private double ramasPlata;
    private int nrRatePlatite;

    public Rata() {
    }

    public Rata(Credit credit, int nrRate) {
        this.nrRate = nrRate;
        this.totalPlata = credit.suma + credit.suma * credit.dobanda;
        this.rata = this.totalPlata / this.nrRate;
        this.ramasPlata = this.totalPlata;
        this.nrRatePlatite = 0;
    }

    public Rata(Credit credit, int nrRate, int nrRatePlatite) {
        this.nrRate = nrRate;
        this.totalPlata = credit.suma + credit.suma * credit.dobanda;
        this.rata = this.totalPlata / this.nrRate;
        this.nrRatePlatite = nrRatePlatite;
        this.ramasPlata = this.totalPlata - this.nrRatePlatite * this.rata;

    }

    public void setNrRatePlatite(int nrRatePlatite) {
        this.nrRatePlatite += nrRatePlatite;
        this.ramasPlata = this.totalPlata - this.nrRatePlatite * this.rata;
    }

    public double getRata() {
        return rata;
    }

    public int getNrRate() {
        return nrRate;
    }

    public double getTotalPlata() {
        return totalPlata;
    }

    public double getRamasPlata() {
        return ramasPlata;
    }

    public int getNrRatePlatite() {
        return nrRatePlatite;
    }

    public void setNrRate(int nrRate) {
        this.nrRate = nrRate;
        this.rata = this.totalPlata/nrRate;
    }

    @Override
    public String toString() {
        return "Rata{" +
                "rata=" + rata +
                ", nrRate=" + nrRate +
                ", totalPlata=" + totalPlata +
                ", ramasPlata=" + ramasPlata +
                ", nrRatePlatite=" + nrRatePlatite +
                '}';
    }
}
