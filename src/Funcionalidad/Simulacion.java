/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

/**
 *
 * @author Usuario
 */
public class Simulacion extends Thread{

    static int tiempoMaximo;
    int probabilidad;
    int tiempoEsperaCola;
    int tiempoEnServicio;

    public Simulacion(int tiempoMaximo) {
        this.tiempoMaximo = tiempoMaximo;
    }

    public static int getTiempo() {
        return tiempoMaximo;
    }

    public static void setTiempo(int tiempoMaximo) {
        //this.tiempoMaximo = tiempoMaximo;
        Simulacion.tiempoMaximo = tiempoMaximo;
    }

    public int getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(int probabilidad) {
        this.probabilidad = probabilidad;
    }
    /**
     * Metodo del hilo
     */
    @Override
    public void run(){
        while(tiempoMaximo>0){
        System.out.println("Hola");
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                //Logger.getLogger(Simulacion.class.getName()).log(Level.SEVERE, null, ex);
            }
            tiempoMaximo--;
        }
    
    }

}
