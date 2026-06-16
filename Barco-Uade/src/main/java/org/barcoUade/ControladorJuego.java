package main.java.org.barcoUade;

import main.java.org.barcoUade.vista.TableroJuego;
import main.java.org.barcoUade.vista.VentanaJuego;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControladorJuego implements KeyListener {

    private Juego juego;
    private TableroJuego tablero;
    private VentanaJuego ventana;
    private Timer gameLoop;
    private int nivelAnterior = 1;
    private int vidasAnterior = 3;

    // 60 FPS
    private final int FPS = 60;
    private final int DELAY = 1000 / FPS;

    public ControladorJuego() {
        juego = new Juego();

        //  Reloj del Juego
        ActionListener tarea = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!juego.isJuegoFinalizado()) {
                    juego.actualizarJuego();

                    // --- DETECCIÓN DE CAMBIO DE NIVEL ---
                    if (juego.getNivelActual() > nivelAnterior) {
                        gameLoop.stop(); // 1. Pausamos el reloj para que no caigan bombas mientras lee

                        JOptionPane.showMessageDialog(ventana, "¡OLEADA SUPERADA!\n" + "Avanzás al Nivel " + juego.getNivelActual() + ".\n" + "Cuidado: Los enemigos son un 20% más rápidos.", "¡Nivel Completado!", JOptionPane.INFORMATION_MESSAGE);

                        nivelAnterior = juego.getNivelActual(); // Actualizamos el rastreador
                        gameLoop.start(); // 2. Retomamos el juego
                    }

                    // --- DETECCIÓN DE CAMBIO DE VIDAS ---
                    if (juego.getVidasSubmarino() > vidasAnterior) {
                        gameLoop.stop(); // Pausamos el juego por el cartel
                        JOptionPane.showMessageDialog(ventana, "¡Excelente comandante!\nAlcanzaste una nueva meta de puntos.\n¡RECIBES 1 VIDA EXTRA!", "¡VIDA EXTRA!", JOptionPane.INFORMATION_MESSAGE);

                        vidasAnterior = juego.getVidasSubmarino(); // Actualizamos la memoria
                        gameLoop.start(); // Retomamos
                    } else if (juego.getVidasSubmarino() < vidasAnterior) {
                        vidasAnterior = juego.getVidasSubmarino(); // Actualizamos la memoria primero

                        // Solo frenamos para mostrar la advertencia si NO fue el golpe letal
                        if (vidasAnterior > 0) {
                            gameLoop.stop(); // Pausamos para darle dramatismo al daño
                            JOptionPane.showMessageDialog(ventana, "¡IMPACTO CRÍTICO!\nEl casco ha sido perforado.\nPERDISTE 1 VIDA.", "¡ALERTA ROJA!", JOptionPane.WARNING_MESSAGE);
                            gameLoop.start();
                        }
                    }

                    // --- DIBUJO NORMAL (Esto ya lo tenías) ---
                    if (tablero != null) {
                        tablero.actualizarTablero(juego.getEstadoSubmarino(), juego.getEstadoBarcos(), juego.getEstadoCargas());
                    }
                    if (ventana != null) {
                        ventana.actualizarHUD(juego.getNivelActual(), juego.getPuntaje(), juego.getVidasSubmarino(), (int) juego.getHpSubmarino(), juego.getBarcosGenerados());
                    }

                } else {
                    // --- EL JUEGO TERMINÓ ---
                    gameLoop.stop(); // Apagamos el reloj definitivamente

                    // Evaluamos si terminó porque ganó o porque murió
                    if (juego.isVictoria()) {
                        JOptionPane.showMessageDialog(ventana, "¡MISIÓN CUMPLIDA, COMANDANTE!\n" + "Sobreviviste los 12 niveles.\n" + "Puntaje Final: " + juego.getPuntaje(), "¡VICTORIA!", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(ventana, "¡EL SUBMARINO FUE DESTRUIDO!\n" + "Nivel alcanzado: " + juego.getNivelActual() + "\n" + "Puntaje Final: " + juego.getPuntaje(), "¡GAME OVER!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        };

        gameLoop = new Timer(DELAY, tarea);
    }

    public void setVentana(VentanaJuego ventana) {
        this.ventana = ventana;
    }

    public void setTablero(TableroJuego tablero) {
        this.tablero = tablero;
    }

    public void iniciarJuego() {
        juego.iniciarJuego();
        gameLoop.start(); // ¡Encendemos el motor!
    }

    // Métodos teclado

    @Override
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();

        if (tecla == KeyEvent.VK_UP) {
            juego.subirSubmarino();
        } else if (tecla == KeyEvent.VK_DOWN) {
            juego.bajarSubmarino();
        } else if (tecla == KeyEvent.VK_LEFT) {
            juego.moverSubmarinoIzquierda();
        } else if (tecla == KeyEvent.VK_RIGHT) {
            juego.moverSubmarinoDerecha();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }


    public int getPuntaje() {
        return juego.getPuntaje();
    }

    public int getVidasSubmarino() {
        return juego.getVidasSubmarino();
    }

    public double getHpSubmarino() {
        return juego.getHpSubmarino();
    }

    public int getNivelActual() {
        return juego.getNivelActual();
    }

    public double getPosicionSubmarinoX() {
        return juego.getPosicionSubmarinoX();
    }

    public double getProfundidadSubmarino() {
        return juego.getProfundidadSubmarino();
    }

    public boolean isJuegoFinalizado() {
        return juego.isJuegoFinalizado();
    }

    public void reiniciarJuego() {
        juego = new Juego();
        juego.iniciarJuego();
        gameLoop.start();
    }
}