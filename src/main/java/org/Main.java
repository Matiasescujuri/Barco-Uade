package org;

import org.barcoUade.ControladorJuego;
import org.barcoUade.Juego;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        ControladorJuego controlador = new ControladorJuego();

        controlador.iniciarJuego();
        controlador.mover();



    }
}
