package org.barcoUade;
import java.util.Random;

public class CargaProfundidad {

    private double posicionX;
    private double profundidadActual;
    private double profundidadExplosion;

    private double velocidadCaida;

    private boolean exploto;

    public CargaProfundidad(double posicionX, double velocidadCaida) {
        this.posicionX = posicionX;
        this.profundidadActual = 0;
        this.velocidadCaida = this.velocidadCaida;
        this.exploto = false;


        generarProfundidadExplosion();

        System.out.println("Carga creadaaa");


    }

    public void caer() {

        profundidadActual += velocidadCaida;
        System.out.println("Carga en caida. profundida actual :" + profundidadActual);

    }

    public void explotar() {
        if (profundidadActual >= profundidadExplosion) {
            exploto = true;
            System.out.println("Carga explota en profundidad " + profundidadExplosion);

        }
    }

    public boolean isExploto() {
        return exploto;
    }


    public void generarProfundidadExplosion() {
        Random random = new Random();

        profundidadExplosion = random.nextInt(401) + 300;
    }

    public double calcularDistancia(Submarino submarino) {
        double distancia =
                Math.abs(
                        profundidadExplosion
                                - submarino.getProfundidad()
                );
        return distancia;

    }
}


