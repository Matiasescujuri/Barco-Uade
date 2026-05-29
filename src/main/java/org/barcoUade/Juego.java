package org.barcoUade;

public class Juego {
    private Submarino submarino;

    private int puntaje;
    private int barcosPendiente;

    private int barcosActivos;
    private Nivel nivel;








    public Juego(){
        puntaje = 0;
        barcosPendiente = 12; // los barcos se organizan en series de 12 unidades
        barcosActivos = 0;
        submarino  = new Submarino();
        nivel  = new Nivel();



    }

    public void iniciarJuego(){
        System.out.println("Juego iniciado");






    }



}
