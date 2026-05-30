package org.barcoUade;

public class ControladorJuego {
    private Juego juego;



    public ControladorJuego(){
        juego = new Juego();
    }

    public void iniciarJuego(){
        juego.iniciarJuego();

    }
    public void mover(){
        juego.actualizarJuego();
    }






















}
