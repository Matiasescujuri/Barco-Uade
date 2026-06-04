package org.barcoUade;

public class Juego {

    private Submarino submarino;

    private int puntaje;
    private int barcosPendiente;
    private int barcosActivos;

    private double velocidadBarcos;
    private double velocidadCargas;

    private Nivel nivel;
    private BarcoEnemigo barco;
    private CargaProfundidad carga;

    private int proximaVidaExtra;
    private boolean juegoFinalizado;

    public Juego() {
        puntaje = 0;
        barcosPendiente = 12;
        barcosActivos = 0;

        velocidadBarcos = 10;
        velocidadCargas = 10;

        submarino = new Submarino();
        nivel = new Nivel();

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

        if (barco != null) {
            barco.mover();
        }

        if (carga == null && barco != null) {
            carga = barco.lanzarCarga(velocidadCargas);
        }

        if (carga != null) {
            carga.caer();
            carga.explotar();
        }

        if (carga != null && carga.isExploto()) {
            procesarExplosion(carga);
            carga = null;
            barcosActivos--;
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
            barco = new BarcoEnemigo(velocidadBarcos);

            barcosActivos++;
            barcosPendiente--;

            System.out.println("barco generado");
            System.out.println("barcos activos: " + barcosActivos);
            System.out.println("barcos pendiente: " + barcosPendiente);
        } else {
            System.out.println("no se puede generar mas barcos");
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
        carga = null;
        barco = null;

        System.out.println("Nivel iniciado");
        nivel.mostrarNivel();

        generarBarco();
    }

    public void pasarDeNivel() {
        puntaje += 200;
        verificarVidaExtra();

        velocidadBarcos *= 1.20;
        velocidadCargas *= 1.20;

        nivel.subirNivel();

        System.out.println("Pasaste de nivel");
        System.out.println("Puntaje actual: " + puntaje);

        iniciarNivel();
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getVidasSubmarino() {
        return submarino.getVidas();
    }

    public double getVidaSubmarino() {
        return submarino.getVida();
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