package main.java.org.barcoUade.vista;

public class BarcoEnemigoDTO {
    private final int id;
    private final double posicionX;
    private final String direccion;

    public BarcoEnemigoDTO(int id, double posicionX, String direccion) {
        this.id = id;
        this.posicionX = posicionX;
        this.direccion = direccion;
    }

    public int getId() { return id; }
    public double getPosicionX() { return posicionX; }
    public String getDireccion() { return direccion; }
}