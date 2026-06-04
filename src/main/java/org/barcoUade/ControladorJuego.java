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

    public void moverSubmarinoIzquierda() {
        juego.moverSubmarinoIzquierda();
    }

    public void moverSubmarinoDerecha() {
        juego.moverSubmarinoDerecha();
    }

    public void subirSubmarino() {
        juego.subirSubmarino();
    }

    public void bajarSubmarino() {
        juego.bajarSubmarino();
    }

    public double getPosicionSubmarinoX() {
        return juego.getPosicionSubmarinoX();
    }

    public double getProfundidadSubmarino() {
        return juego.getProfundidadSubmarino();
    }
    public void reiniciarJuego() {
        juego = new Juego();
        juego.iniciarJuego();
    }
    public boolean isJuegoFinalizado() {
        return juego.isJuegoFinalizado();
    }

}
