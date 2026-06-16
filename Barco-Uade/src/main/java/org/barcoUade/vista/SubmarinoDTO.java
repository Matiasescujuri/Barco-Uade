package main.java.org.barcoUade.vista;

public class SubmarinoDTO {
    private final double posicionX;
    private final double profundidad;
    private final double hp;
    private final int vidas;

    public SubmarinoDTO(double posicionX, double profundidad, double hp, int vidas) {
        this.posicionX = posicionX;
        this.profundidad = profundidad;
        this.hp = hp;
        this.vidas = vidas;
    }

    public double getPosicionX() {
        return posicionX;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public double getHp() {
        return hp;
    }

    public int getVidas() {
        return vidas;
    }
}