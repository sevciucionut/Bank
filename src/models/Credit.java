package models;

public class Credit {
    protected double suma;
    protected double dobanda;

    public Credit(double suma, double dobanda) {
        this.suma = suma;
        this.dobanda = dobanda;
    }

    public Credit() {
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public void setDobanda(double dobanda) {
        this.dobanda = dobanda;
    }

    public double getSuma() {
        return suma;
    }

    public double getDobanda() {
        return dobanda;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "suma=" + suma +
                ", dobanda=" + dobanda +
                '}';
    }
}
