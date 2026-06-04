package org.barcoUade;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaJuego extends JFrame {

    private ControladorJuego controlador;
    private JLabel titulo;
    private JLabel lblNivel;
    private JLabel lblPuntaje;
    private JLabel lblVidas;

    public VentanaJuego() {
        controlador = new ControladorJuego();

        setTitle("Barco UADE");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        titulo = new JLabel("Barco UADE");

        lblNivel = new JLabel("Nivel: 0");
        lblPuntaje = new JLabel("Puntaje: 0");
        lblVidas = new JLabel("Vidas: 0");
        JButton btnIzquierda = new JButton("←");
        JButton btnDerecha = new JButton("→");
        JButton btnSubir = new JButton("↑");
        JButton btnBajar = new JButton("↓");
        JButton botonIniciar = new JButton("START GAME");



        JButton btnIzquierda = new JButton("←");
        JButton btnDerecha = new JButton("→");
        JButton btnSubir = new JButton("↑");
        JButton btnBajar = new JButton("↓");





        botonIniciar.addActionListener(e -> {
            controlador.iniciarJuego();


            titulo.setText("Juego iniciado");

            lblNivel.setText("Nivel: " + controlador.getNivelActual());
            lblPuntaje.setText("Puntaje: " + controlador.getPuntaje());
            lblVidas.setText("Vidas: " + controlador.getVidasSubmarino());

        });
        btnIzquierda.addActionListener(e -> {
            controlador.moverSubmarinoIzquierda();
        });

        btnDerecha.addActionListener(e -> {
            controlador.moverSubmarinoDerecha();
        });

        btnSubir.addActionListener(e -> {
            controlador.subirSubmarino();
        });

        btnBajar.addActionListener(e -> {
            controlador.bajarSubmarino();
        });


        panel.add(titulo);
        panel.add(botonIniciar);
        panel.add(titulo);
        panel.add(lblNivel);
        panel.add(lblPuntaje);
        panel.add(lblVidas);
        panel.add(botonIniciar);
        panel.add(btnIzquierda);
        panel.add(btnDerecha);
        panel.add(btnSubir);
        panel.add(btnBajar);

        add(panel);

        setVisible(true);
    }
}