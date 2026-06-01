package org.barcoUade;

public class Submarino {

    private double posicionX;
    private double profundidad;
    private int vidas;
    private double vida;
    private  String direccion;

    public Submarino() {

        posicionX = 0.0; // porque no un entero?
        profundidad = 300.0; // porque no un entero?
        vidas = 3;
        vida = 100;
        direccion = "derecha";



        System.out.println("submarino creado");
    }

    public void moverIzquierda(){
        posicionX--;  // mismo que -1
        direccion = "izquierda";
        System.out.println("submarino moviendose a la izquierda");


    }

    public void moverDerecha(){
        posicionX++;
        direccion = "derecha";
        System.out.println("submarino moviendose a la derecha");



    }
    public void subir(){
        if(profundidad > 300){
            profundidad -= 10;

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

    public double getVida() {
        return vida;
    }
    public void bajar(){
        if(profundidad < 800){
            profundidad += 10;

        }
    }
    public void recibirDanio(double porcentajedanio){
        vida -= porcentajedanio;

        if(vida <= 0){
            vidas --;
            vida = 100;

        }

        if(vidas < 0){
            vidas = 0;

        }
    }
}
