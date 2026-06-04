package org.barcoUade;

public class TestControladorJuego {

    public static void main(String[] args) {

        ControladorJuego controlador = new ControladorJuego();

        controlador.iniciarJuego();

        System.out.println("=== ESTADO INICIAL ===");
        mostrarEstado(controlador);

        controlador.moverSubmarinoDerecha();
        controlador.moverSubmarinoDerecha();
        controlador.bajarSubmarino();

        System.out.println("=== DESPUES DE MOVER SUBMARINO ===");

        mostrarEstado(controlador);

        controlador.mover();

        for (int i = 0; i < 25; i++) {
            controlador.bajarSubmarino();
        }

        for (int i = 0; i < 2000; i++) {
            controlador.mover();
        }

        System.out.println("Nivel actual: " + controlador.getNivelActual());

        System.out.println("=== DESPUES DE ACTUALIZAR JUEGO ===");
        mostrarEstado(controlador);


        if (controlador.isJuegoFinalizado()) {
            System.out.println("GAME OVER");
            System.out.println("1 - Reiniciar");
            System.out.println("2 - Salir");
        }
    }

    private static void mostrarEstado(ControladorJuego controlador) {
        System.out.println("Nivel: " + controlador.getNivelActual());
        System.out.println("Puntaje: " + controlador.getPuntaje());
        System.out.println("Vidas: " + controlador.getVidasSubmarino());
        System.out.println("Vida %: " + controlador.getVidaSubmarino());
        System.out.println("Posicion X: " + controlador.getPosicionSubmarinoX());
        System.out.println("Profundidad: " + controlador.getProfundidadSubmarino());
        System.out.println("Juego finalizado: " + controlador.isJuegoFinalizado());
    }

}