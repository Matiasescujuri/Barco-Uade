package main.java.org.barcoUade.vista;

public class CargaProfundidadDTO {
    private final double posicionX;
    private final double profundidadActual;
    private final boolean exploto;

    public CargaProfundidadDTO(double posicionX, double profundidadActual, boolean exploto) {
        this.posicionX = posicionX;
        this.profundidadActual = profundidadActual;
        this.exploto = exploto;
    }

    public double getPosicionX() { return posicionX; }
    public double getProfundidadActual() { return profundidadActual; }
    public boolean isExploto() { return exploto; } // NUEVO
}