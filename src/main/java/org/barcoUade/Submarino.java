package org.barcoUade;

public class Submarino {

    private Double posicionX;
    private Double profundidad;
    private int vidas;
    private double vida;
    private  String direccion;

    public Submarino() {

        posicionX = 0.0; // porque no un entero?
        profundidad = 300.0; // porque no un entero?
        vida = 0;
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
    public void bajar(){
        if(profundidad < 800){
            profundidad += 10;

        }
    }
}
