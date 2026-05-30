package org.barcoUade;

public class Juego {
    private Submarino submarino;

    private int puntaje;
    private int barcosPendiente;

    private int barcosActivos;
    private Nivel nivel;
    private BarcoEnemigo barco;
    private CargaProfundidad carga;








    public Juego(){
        puntaje = 0;
        barcosPendiente = 12; // los barcos se organizan en series de 12 unidades
        barcosActivos = 0;
        submarino  = new Submarino();
        nivel  = new Nivel();




    }

    public void iniciarJuego(){
        System.out.println("Juego iniciado");
        generarBarco();


    }
    public void actualizarJuego(){
        System.out.println(" juego actualizando ");
        if(barco != null){
            barco.mover();
        }
        if(carga == null && barco != null){
            carga = barco.lanzarCarga(
                    nivel.getVelocidadBarcos());
        }
        if(carga != null){
            carga.caer();
            carga.explotar();

        }
        if(carga.isExploto()){
            procesarExplosion(carga);
        }
        verificarPasoNivel();

    }
    public void verificarPasoNivel(){
        System.out.println("verificando paso de nivel");
        nivel.mostrarNivel();

    }
    public void generarBarco(){
        if (barcosActivos < 3 && barcosPendiente > 0){
            barco = new BarcoEnemigo(nivel.getVelocidadBarcos());
            barcosActivos++;
            barcosPendiente--;
            System.out.println("barco generado");
            System.out.println("barcos activos:" + barcosActivos);
            System.out.println("barcos pendiente:" + barcosPendiente);

        }else{
            System.out.println("no se puede generar mas barcos");
        }

    }
    public void procesarExplosion(CargaProfundidad carga){
        System.out.println("procesando explosion");
    }



}
