package main.java.org.barcoUade;

import java.util.Random;

public class CargaProfundidad {

    private double posicionX;
    private double profundidadActual;
    private double profundidadExplosion;
    private double velocidadCaida;
    private boolean exploto;
    private int tiempoVisualExplosion = 30;

    public CargaProfundidad(double posicionX, double velocidadCaida) {
        this.posicionX = posicionX;
        this.profundidadActual = 0;
        this.velocidadCaida = velocidadCaida;
        this.exploto = false;

        generarProfundidadExplosion();

        System.out.println("Carga creada");
    }

    public void caer() {
        profundidadActual += velocidadCaida;
        //System.out.println("Carga en caida. profundidad actual: " + profundidadActual);
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
        double diferenciaX = posicionX - submarino.getPosicionX();
        double diferenciaProfundidad = profundidadExplosion - submarino.getProfundidad();

        double distancia = Math.sqrt(
                diferenciaX * diferenciaX +
                        diferenciaProfundidad * diferenciaProfundidad
        );

        return distancia;
    }

    // Métodos para el temporizador
    public void reducirTiempoVisual() {
        this.tiempoVisualExplosion--;
    }

    public int getTiempoVisualExplosion() {
        return this.tiempoVisualExplosion;
    }

    public double getPosicionX() {
        return posicionX;
    }

    public double getProfundidadExplosion() {
        return profundidadExplosion;
    }

    public double getProfundidadActual() {
        return profundidadActual;
    }
}