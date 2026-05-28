package org.barcoUade;
import java.util.Random;

public class CargaProfundidad {

    private double posicionX;
    private double profundidadActual;
    private double ProfundidadExplosion;

    private double velocidadCaida;

    private boolean exploto;

    public CargaProfundidad(double posicionX) {
        this.posicionX = posicionX;
        this.profundidadActual = 0;
        this.velocidadCaida = 0;
        this.exploto = false;


        generarProfundidadExplosion();

        System.out.println("Carga creadaaa");


    }

    public void caer() {

        profundidadActual += velocidadCaida;
        System.out.println("Carga en caida. profundida actual :" + profundidadActual);

    }

    public void explotar() {
        if(profundidadActual >= ProfundidadExplosion)
        exploto = true;
        System.out.println("Carga explota en profundidad " + ProfundidadExplosion);

    }



    public void generarProfundidadExplosion() {
        Random random = new Random();

        ProfundidadExplosion = random.nextInt(401) + 300;
    }
}

