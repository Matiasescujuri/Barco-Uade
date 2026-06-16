package main.java.org.barcoUade.vista;

import main.java.org.barcoUade.vista.SubmarinoDTO;
import main.java.org.barcoUade.vista.BarcoEnemigoDTO;
import main.java.org.barcoUade.vista.CargaProfundidadDTO;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class TableroJuego extends JPanel {

    // El tablero guarda "fotos" (DTOs) de lo que tiene que dibujar
    private SubmarinoDTO submarino;
    private List<BarcoEnemigoDTO> barcos = new ArrayList<>();
    private List<CargaProfundidadDTO> bombas = new ArrayList<>();

    private Image imgSubmarino;
    private Image imgBarco;
    private Image imgBomba;
    private Image imgFondo;
    private Image imgExplosion;

    public TableroJuego() {
        // Le damos un color de fondo azul marino al panel
        setBackground(new Color(30, 144, 255));
        setPreferredSize(new Dimension(800, 850));

        imgSubmarino = new ImageIcon("C:\\Users\\Nacho\\Desktop\\untitled\\Barco-Uade\\src\\images\\imgSubmarino.png").getImage();
        imgBarco = new ImageIcon("C:\\Users\\Nacho\\Desktop\\untitled\\Barco-Uade\\src\\images\\barco.png").getImage();
        imgBomba = new ImageIcon("C:\\Users\\Nacho\\Desktop\\untitled\\Barco-Uade\\src\\images\\bomba.png").getImage();
        imgFondo = new ImageIcon("C:\\Users\\Nacho\\Desktop\\untitled\\Barco-Uade\\src\\images\\fondo.jpg").getImage();
        imgExplosion = new ImageIcon("C:\\Users\\Nacho\\Desktop\\untitled\\Barco-Uade\\src\\images\\explosion.png").getImage();
    }

    // Este es el metodo por el que la Vista recibe los datos nuevos del Controlador
    public void actualizarTablero(SubmarinoDTO sub, List<BarcoEnemigoDTO> barcos, List<CargaProfundidadDTO> bombas) {
        this.submarino = sub;
        this.barcos = barcos;
        this.bombas = bombas;

        // ¡Magia de Swing! Le avisa a Java que tiene que volver a dibujar todo
        repaint();
    }

    // Acá está el pincel real del juego
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 0. Dibujar el Fondo del mar (Ocupa todo el tablero)
        if (imgFondo != null) {
            g.drawImage(imgFondo, 0, 0, 800, 850, this);
        }

        // 1. Dibujar el Submarino
        if (submarino != null) {
            // Reemplazamos fillRect por drawImage.
            // Los números 60 y 30 son el ancho y alto en píxeles. Ajustalos al tamaño que te guste.
            g.drawImage(imgSubmarino, (int) submarino.getPosicionX(), (int) submarino.getProfundidad() - 30, 100, 100, this);
        }

        // 2. Dibujar los Barcos Enemigos
        for (BarcoEnemigoDTO barco : barcos) {
            // Los dibujamos en Y = 0 (superficie)
            g.drawImage(imgBarco, (int) barco.getPosicionX(), -20, 100, 100, this);
        }

        // 3. Dibujar las Bombas (Cargas de Profundidad)
        for (CargaProfundidadDTO bomba : bombas) {
            if (bomba.isExploto()) {
                // Si explotó, dibujamos el fuego un poco más grande y centrado
                g.drawImage(imgExplosion, (int) bomba.getPosicionX() - 10, (int) bomba.getProfundidadActual() - 10, 60, 60, this);
            } else {
                // Si no explotó, dibujamos la bomba negra normal cayendo
                g.drawImage(imgBomba, (int) bomba.getPosicionX(), (int) bomba.getProfundidadActual(), 40, 40, this);
            }
        }
    }
}

