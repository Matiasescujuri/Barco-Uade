package org.barcoUade;

import java.util.Random;

public class BarcoEnemigo {

    private double posicionX;
    private String direccion;
    private double velocidadMovimiento;

    public BarcoEnemigo(double velocidadMovimiento) {
        this.posicionX = 0;
        this.velocidadMovimiento = velocidadMovimiento;

        Random random = new Random();

        if (random.nextBoolean()) {
            this.direccion = "derecha";
        } else {
            this.direccion = "izquierda";
        }
    }

    public void mover() {
        if (direccion.equals("derecha")) {
            posicionX += velocidadMovimiento;
        } else {
            posicionX -= velocidadMovimiento;
        }
        System.out.println(
                "barco moviendose hacia   "
                        + direccion
                        + "posicion"
                        + posicionX
        );
    }

    public CargaProfundidad lanzarCarga(double velocidadCaida) {
        System.out.println("barco lanzo una  carga");
        return new CargaProfundidad(posicionX, velocidadCaida);

    }

    public double getPosicionX() {
        return posicionX;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getVelocidadMovimiento() {
        return velocidadMovimiento;
    }
}