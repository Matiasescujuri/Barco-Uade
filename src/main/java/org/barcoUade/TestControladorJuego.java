package org.barcoUade;

public class TestControladorJuego {

    public static void main(String[] args) {

        ControladorJuego controlador = new ControladorJuego();

        controlador.iniciarJuego();

        System.out.println("Nivel: " + controlador.getNivelActual());
        System.out.println("Puntaje: " + controlador.getPuntaje());
        System.out.println("Vidas: " + controlador.getVidasSubmarino());

        controlador.mover();
    }
}