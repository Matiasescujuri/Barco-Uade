package org.barcoUade;

public class Nivel {

    private int numeroNivel;
    private double velocidadBarcos;
    private double velocidadCargas;




    public Nivel() {

        this.numeroNivel = 1;
        this.velocidadBarcos = 1.0;
        this.velocidadCargas = 1.0;
    }


    public void mostrarNivel() {
        System.out.println("SU nivel actual es  " +  this.numeroNivel);
    }


    public void subirNivel(){
        this.numeroNivel++;
        aumentarVelocidad();
        System.out.println("SUBISTE al nivel" + this.numeroNivel);

    }
    public void aumentarVelocidad(){
        this.velocidadBarcos += this.velocidadBarcos * 1.20;
        this.velocidadCargas += this.velocidadCargas * 1.20;

    }
    public int getNumeroNivel() {
        return numeroNivel;
    }
    public double getVelocidadBarcos() {
        return velocidadBarcos;
    }
    public double getVelocidadCargas() {
        return velocidadCargas;
    }





}
