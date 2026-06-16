package main.java.org.barcoUade;

import main.java.org.barcoUade.vista.SubmarinoDTO;
import main.java.org.barcoUade.vista.BarcoEnemigoDTO;
import main.java.org.barcoUade.vista.CargaProfundidadDTO;

import java.util.ArrayList;
import java.util.List;

public class Juego {

    private Submarino submarino;

    private int puntaje;
    private int barcosPendiente;
    private int barcosActivos;
    private boolean victoria;

    private double velocidadBarcos;
    private double velocidadCargas;

    private Nivel nivel;
    private BarcoEnemigo[] barcos;
    private CargaProfundidad[] cargas;

    private int proximaVidaExtra;
    private boolean juegoFinalizado;

    public Juego() {
        puntaje = 0;
        barcosPendiente = 12;
        barcosActivos = 0;

        velocidadBarcos = 2;
        velocidadCargas = 3;

        submarino = new Submarino();
        nivel = new Nivel();

        barcos = new BarcoEnemigo[3];
        cargas = new CargaProfundidad[30];

        proximaVidaExtra = 500;
        juegoFinalizado = false;
    }

    public void iniciarJuego() {
        System.out.println("Juego iniciado");
        iniciarNivel();
    }

    public void actualizarJuego() {
        if (juegoFinalizado) {
            return;
        }

        System.out.println("juego actualizando");

        generarBarco();

        // nueva lógica
        // --- 1. LÓGICA DE LOS BARCOS ---
        for (int i = 0; i < barcos.length; i++) {

            if (barcos[i] != null) {
                barcos[i].mover();

                // ---> ¡ACÁ VA EL PASO 2! Agregamos "barcos[i].tieneMunicion() &&" <---
                if (barcos[i].tieneMunicion() && Math.random() > 0.98) {

                    // Buscamos un espacio vacío en el arreglo de bombas (j)
                    for (int j = 0; j < cargas.length; j++) {
                        if (cargas[j] == null) {
                            cargas[j] = barcos[i].lanzarCarga(velocidadCargas);
                            break;
                        }
                    }
                }

                // Borra al barco si salió del mapa
                if (barcos[i].getPosicionX() > 850 || barcos[i].getPosicionX() < -50) {
                    barcos[i] = null;
                    barcosActivos--;
                }
            }
        }


        //LÓGICA DE LAS BOMBAS ---
        for (int j = 0; j < cargas.length; j++) {
            if (cargas[j] != null) {
                if (!cargas[j].isExploto()) {
                    cargas[j].caer();
                    cargas[j].explotar();

                    if (cargas[j].isExploto()) {
                        procesarExplosion(cargas[j]);
                    }
                } else {
                    cargas[j].reducirTiempoVisual();
                    if (cargas[j].getTiempoVisualExplosion() <= 0) {
                        cargas[j] = null;
                    }
                }
            }
        }

        verificarPasoNivel();
        finalizarJuego();
    }

    public void verificarPasoNivel() {
        if (barcosPendiente == 0 && barcosActivos == 0) {
            pasarDeNivel();
        }
    }

    public void generarBarco() {
        if (barcosActivos < 3 && barcosPendiente > 0) {
            for (int i = 0; i < barcos.length; i++) {

                if (barcos[i] == null && cargas[i] == null) {
                    barcos[i] = new BarcoEnemigo(velocidadBarcos);
                    barcosActivos++;
                    barcosPendiente--;

                    //System.out.println("barco generado");
                    //System.out.println("barcos activos: " + barcosActivos);
                    //System.out.println("barcos pendiente: " + barcosPendiente);

                    break;
                }
            }
        }
    }

    public void procesarExplosion(CargaProfundidad carga) {
        System.out.println("procesando explosion");

        double distancia = carga.calcularDistancia(submarino);
        System.out.println("Distancia calculada: " + distancia);

        if (distancia > 100) {
            puntaje += 30;
            System.out.println("Explosion lejana. +30 puntos");
        } else if (distancia >= 50) {
            puntaje += 10;
            submarino.recibirDanio(30);
            System.out.println("Explosion media. +10 puntos y 30% de daño");
        } else if (distancia >= 10) {
            submarino.recibirDanio(50);
            System.out.println("Explosion cercana. 50% de daño");
        } else {
            submarino.recibirDanio(100);
            System.out.println("Explosion directa. Pierde una vida");
        }

        System.out.println("Puntaje actual: " + puntaje);
        verificarVidaExtra();

        if (submarino.getVidas() <= 0) {
            this.juegoFinalizado = true;
        }
    }

    public void verificarVidaExtra() {
        if (puntaje >= proximaVidaExtra) {
            submarino.ganarVida();
            System.out.println("Vida extra obtenida");
            proximaVidaExtra += 500;
        }
    }

    public void finalizarJuego() {
        if (submarino.getVidas() <= 0) {
            juegoFinalizado = true;
            System.out.println("Juego finalizado");
        }
    }

    public void iniciarNivel() {
        barcosPendiente = 12;
        barcosActivos = 0;

        barcos = new BarcoEnemigo[3];
        cargas = new CargaProfundidad[3];

        System.out.println("Nivel iniciado");
        nivel.mostrarNivel();

        generarBarco();
    }

    public void pasarDeNivel() {
        if (nivel.getNumeroNivel() == 12) {
            juegoFinalizado = true;
            victoria = true;
            return;
        }

        puntaje += 200;
        verificarVidaExtra();

        velocidadBarcos *= 1.20;
        velocidadCargas *= 1.20;

        nivel.subirNivel();

        System.out.println("Pasaste de nivel");
        System.out.println("Puntaje actual: " + puntaje);

        iniciarNivel();
    }

    public SubmarinoDTO getEstadoSubmarino() {
        return new SubmarinoDTO(submarino.getPosicionX(), submarino.getProfundidad(), submarino.getHp(), submarino.getVidas());
    }

    public List<BarcoEnemigoDTO> getEstadoBarcos() {
        List<BarcoEnemigoDTO> barcosDTO = new ArrayList<>();
        // Recorremos el arreglo fijo de tu compañero
        for (int i = 0; i < barcos.length; i++) {
            if (barcos[i] != null) {
                barcosDTO.add(new BarcoEnemigoDTO(i, barcos[i].getPosicionX(), barcos[i].getDireccion()));
            }
        }
        return barcosDTO;
    }

    public List<CargaProfundidadDTO> getEstadoCargas() {
        List<CargaProfundidadDTO> cargasDTO = new ArrayList<>();
        for (int i = 0; i < cargas.length; i++) {
            if (cargas[i] != null) {
                cargasDTO.add(new CargaProfundidadDTO(cargas[i].getPosicionX(), cargas[i].getProfundidadActual(), cargas[i].isExploto()));
            }
        }
        return cargasDTO;
    }

    public int getBarcosGenerados() {
        return 12 - this.barcosPendiente;
    }

    //
    public boolean isVictoria() {
        return victoria;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getVidasSubmarino() {
        return submarino.getVidas();
    }

    public double getHpSubmarino() {
        return submarino.getHp();
    }

    public int getNivelActual() {
        return nivel.getNumeroNivel();
    }

    public void moverSubmarinoIzquierda() {
        submarino.moverIzquierda();
    }

    public void moverSubmarinoDerecha() {
        submarino.moverDerecha();
    }

    public void subirSubmarino() {
        submarino.subir();
    }

    public void bajarSubmarino() {
        submarino.bajar();
    }

    public double getPosicionSubmarinoX() {
        return submarino.getPosicionX();
    }

    public double getProfundidadSubmarino() {
        return submarino.getProfundidad();
    }

    public boolean isJuegoFinalizado() {
        return juegoFinalizado;
    }
}