package org.barcoUade;

public class ControladorJuego {

    private Juego juego;

    public ControladorJuego() {
        juego = new Juego();
    }

    public void iniciarJuego() {
        juego.iniciarJuego();
    }

    public void mover() {
        juego.actualizarJuego();
    }

    public int getPuntaje() {
        return juego.getPuntaje();
    }

    public int getVidasSubmarino() {
        return juego.getVidasSubmarino();
    }

    public double getVidaSubmarino() {
        return juego.getVidaSubmarino();
    }

    public int getNivelActual() {
        return juego.getNivelActual();
    }
}