package main.java.org.barcoUade;

import java.util.Random;

public class BarcoEnemigo {

    private double posicionX;
    private String direccion;
    private double velocidadMovimiento;
    private int municion;

    public BarcoEnemigo(double velocidadMovimiento) { // modifiqué esta lógica para que sea random de donde salen
        this.velocidadMovimiento = velocidadMovimiento;
        Random random = new Random();

        this.municion = random.nextInt(3) + 1;

        if (random.nextBoolean()) {
            this.posicionX = -50.0;
            this.direccion = "derecha";
        } else {
            this.posicionX = 850.0;
            this.direccion = "izquierda";
        }
    }

    public void mover() {
        if (direccion.equals("derecha")) {
            posicionX += velocidadMovimiento;
        } else {
            posicionX -= velocidadMovimiento;
        }
        // System.out.println("barco moviendose hacia   " + direccion + "posicion" + posicionX);
    }

    public boolean tieneMunicion() {
        return this.municion > 0;
    }

    public CargaProfundidad lanzarCarga(double velocidadCaida) {
        this.municion--;
        //System.out.println("barco lanzo una carga");
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