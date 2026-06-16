package main.java.org.barcoUade;

public class Nivel {

    private int numeroNivel;

    public Nivel() {
        this.numeroNivel = 1;
    }

    public void mostrarNivel() {
        System.out.println("SU nivel actual es " + this.numeroNivel);
    }

    public void subirNivel() {
        this.numeroNivel++;
        System.out.println("SUBISTE al nivel " + this.numeroNivel);
    }

    public int getNumeroNivel() {
        return numeroNivel;
    }
}