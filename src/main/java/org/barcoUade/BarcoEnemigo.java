package org.barcoUade;

public class BarcoEnemigo {


    private double posicionX; // izquierda y derecha
    private String direccion;
    private double velocidadMovimiento;


    public void barcoEnemigo(){
        posicionX = 0;
        direccion = "derecha";
        velocidadMovimiento = 2.0;
    }


    public void mover(){
        if(direccion.equals("derecha")) {
            posicionX = posicionX + velocidadMovimiento;
        }else{
            posicionX = posicionX - velocidadMovimiento;

        }
        System.out.println("barco moviendose");

    }


    public CargaProfundidad lanzarCarga(){
        System.out.println("barco lanzo una carga");

        return new CargaProfundidad(posicionX);

    }

}
