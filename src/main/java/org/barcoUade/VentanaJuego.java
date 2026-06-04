package org.barcoUade;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class VentanaJuego extends JFrame {
    private ControladorJuego controlador;
    private ControladorJuego controlador;

    public VentanaJuego() {
        controlador = new ControladorJuego();

        // ventana...

        JLabel titulo = new JLabel("Barco UADE");
        JButton botonIniciar = new JButton("Iniciar juego");

        botonIniciar.addActionListener(e -> {
            controlador.iniciarJuego();
            titulo.setText("Juego iniciado - Nivel: " + controlador.getNivelActual());
        });


        panel.add(titulo);
        panel.add(botonIniciar);
    }


























}