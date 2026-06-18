package main.java.org.barcoUade.vista; // Ajustá el paquete si lo moviste a la carpeta "vista"

import main.java.org.barcoUade.ControladorJuego;
import main.java.org.barcoUade.vista.TableroJuego;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

public class VentanaJuego extends JFrame {

    private ControladorJuego controlador;
    private TableroJuego tablero; // Traemos el lienzo que dibujará los DTOs

    private JLabel lblNivel;
    private JLabel lblPuntaje;
    private JLabel lblVidas;
    private JLabel lblHp;
    private JLabel lblOleada;

    public VentanaJuego() {
        // 1. Inicializamos el Controlador y el Lienzo
        controlador = new ControladorJuego();
        tablero = new TableroJuego();

        // ¡Magia! Le pasamos el lienzo al controlador para que pueda dibujar
        controlador.setTablero(tablero);
        controlador.setVentana(this);

        // 2. Configuración básica de la ventana
        setTitle("Submarine Attack - UADE");
        //setSize(800, 1500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Usamos BorderLayout para dividir la pantalla en "Norte", "Sur", "Centro", etc.
        setLayout(new BorderLayout());

        // 3. Panel Superior (HUD)
        JPanel panelHUD = new JPanel();
        panelHUD.setLayout(new FlowLayout()); // Los elementos se ponen uno al lado del otro
        panelHUD.setBackground(Color.LIGHT_GRAY);

        lblNivel = new JLabel("Nivel: 1  |  ");
        lblOleada = new JLabel("Barcos: 0/12  |  ");
        lblPuntaje = new JLabel("Puntaje: 0  |  ");
        lblHp = new JLabel("HP: 100");
        lblVidas = new JLabel("Vidas: 3");

        JButton botonIniciar = new JButton("START GAME");

        // ¡TRUCO VITAL EN SWING!
        // Evita que el botón se quede con el "Foco" del teclado después de hacerle clic
        botonIniciar.setFocusable(false);

        botonIniciar.addActionListener(e -> {
            controlador.iniciarJuego();
            botonIniciar.setEnabled(false); // Apagamos el botón para no apretarlo dos veces por error
            requestFocusInWindow(); // Obligamos a la ventana a volver a prestar atención al teclado
        });

        // Sumamos los textos y botones al panel chiquito
        panelHUD.add(botonIniciar);
        panelHUD.add(lblNivel);
        panelHUD.add(lblOleada);
        panelHUD.add(lblPuntaje);
        panelHUD.add(lblHp);
        panelHUD.add(lblVidas);

        // 4. Ensamblamos la ventana
        add(panelHUD, BorderLayout.NORTH); // El HUD se pega al techo de la ventana
        add(tablero, BorderLayout.CENTER); // El Tablero gigante ocupa el resto del centro

        // 5. Conectamos las "orejas" (El KeyListener del Controlador) a la ventana
        addKeyListener(controlador);
        setFocusable(true); // Obligamos a que la ventana entera pueda escuchar al teclado

        pack(); // Acomoda la ventana al tamaño exacto de 800x850 que le pedimos al Tablero
        setLocationRelativeTo(null); // Centra la ventana en el monitor (importante que esté después del pack)

        setVisible(true);
    }

    // Este metodo lo puede llamar el Controlador en cada fotograma
    // para que los numeritos de arriba se actualicen en tiempo real
    public void actualizarHUD(int nivel, int puntaje, int vidas, int hp, int barcos) {
        lblNivel.setText("Nivel: " + nivel + "  |  ");
        lblOleada.setText("Barcos: " + barcos + "/12  |  ");
        lblPuntaje.setText("Puntaje: " + puntaje + "  |  ");
        lblHp.setText("Salud: " + (int) hp + "%  |  ");
        lblVidas.setText("Vidas: " + vidas);
    }
}