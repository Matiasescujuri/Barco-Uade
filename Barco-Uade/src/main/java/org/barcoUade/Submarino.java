package main.java.org.barcoUade;

public class Submarino {

    private double posicionX;
    private double profundidad;
    private int vidas;
    private double hp;
    private String direccion;
    // Nuevo
    private double velocidadHorizontal;
    private double velocidadVertical;

    public Submarino() {

        posicionX = 350.0; // porque no un entero?
        profundidad = 300.0; // porque no un entero?
        vidas = 3;
        hp = 100;
        direccion = "derecha";

        velocidadHorizontal = 15.0;
        velocidadVertical = 15.0;

        //System.out.println("submarino creado");
    }

    public void moverIzquierda() {
        posicionX -= velocidadHorizontal;  // mismo que -1
        direccion = "izquierda";
        if (posicionX < 0) {
            posicionX = 0;
        }


        //System.out.println("submarino moviendose a la izquierda");


    }

    public void moverDerecha() {
        posicionX += velocidadHorizontal;
        direccion = "derecha";
        if (posicionX > 700) {
            posicionX = 700;
        }

        //System.out.println("submarino moviendose a la derecha");


    }

    public void subir() {
        if (profundidad > 300) {
            profundidad -= velocidadVertical;

        }

    }

    public void bajar() {
        if (profundidad < 800) {
            profundidad += velocidadVertical;

        }
    }

    public void recibirDanio(double porcentajedanio) {
        hp -= porcentajedanio;

        if (hp <= 0) {
            vidas--;
            hp = 100;

        }

        if (vidas < 0) {
            vidas = 0;

        }
    }

    public double getPosicionX() {
        return posicionX;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public int getVidas() {
        return vidas;
    }

    public double getHp() {
        return hp;
    }

    public void ganarVida() {
        vidas++;
    }
}
