/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import Imprenta.Imprenta;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Simulacion extends Thread{
    private Imprenta imprenta=new Imprenta();
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
        double creacionCliente = Math.random() * 1;
        try {
            if (creacionCliente >= 0.5) {

                System.out.println(creacionCliente);
                System.out.println("¡¡Hay un nuevo cliente!!");
                System.out.println(" ");
                imprenta.add(new Cliente("RAFA",tiempoMaximo,1));
                //crear cliente
                //Cliente("Angel", 12);
                sleep(2000);
                tiempoMaximo-=2;

            } else {
                System.out.println(creacionCliente);
                System.out.println("No hay nuevo cliente :(");
                System.out.println(" ");

                //no se crea cliente
                sleep(2000);
                tiempoMaximo-=2;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Simulacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    }

}
