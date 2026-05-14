package org.barcoUade;

public class Juego {


    private int puntaje;
    private int barcosPendiente;

    private int barcosActivos;

    private Submarino submarino;


    public Juego(){
        puntaje = 0;
        barcosPendiente = 12; // los barcos se organizan en series de 12 unidades
        barcosActivos = 0;

    }

    public void iniciarJuego(){
        System.out.println("Juego iniciado");

        submarino = new Submarino();


    }



}
