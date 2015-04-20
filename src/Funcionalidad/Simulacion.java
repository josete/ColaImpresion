/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import Imprenta.Imprenta;
import java.awt.SystemColor;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Simulacion extends Thread {
    Random rnd = new Random();
    private Imprenta imprenta = new Imprenta();
    static int tiempoMaximo;
    private UtilidadesTiempo util = new UtilidadesTiempo();
    int probabilidad;
    int tiempoEsperaCola;
    int tiempoEnServicio;
    int tiempoServicioCliente;
    int tiempoServicioAleatorio = 0;
    int i = 0;
    String[]pilaNombres={"Pedro", "Pablo","Rafa", "Jose", "Angel", "Cristiano", "Raúl", "Gareth","Federico",
        "Iker", "Saúl","Walter","Jessie","Roberto","Andrea","Lucía","Julia", "Catalina","Azucena",
        "Alejandro","Álvaro","Alberto", "Olga", "Laura",
        "Patricia","Borja","Marta","Macarena","Irina", "Armando","Aitor", "Ester","Jonhy","Nicolás",
        "Fernando","Javier","Lorena","Ignacio","María","Carmen","Antonio","Jesús","Ana","Paloma","Miguel",
        "Jaime","Mickey","Mercedes","Dolores","Gustavo","Sergio","Carlos","Paula","Rita",""};
    String[]pilaApellidos={"García","Tilla","Cristo","González", "Laso",
        "Nadal","López","Fernández","Shaik","Tormenta","Castillo","Torres","Núñez","Moreno","Murillo",
        "Casillas","Mouse","Iglesias","Benz","White","Pinkman","Pérez","Gómez","Manzano","Martínez",
        "Fuertes" };
    public String generarNombre(){
        
        int generado=(int)(rnd.nextDouble()*pilaNombres.length);
        int generado2=(int)(rnd.nextDouble()*pilaApellidos.length);
        return pilaNombres[generado]+" "+pilaApellidos[generado2];
    }

    public Simulacion(int tiempoMaximo) {
        this.tiempoMaximo = tiempoMaximo;
        imprenta.setTiempoMax(10);
        imprenta.setTiempoMin(1);
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
    public void run() {
        while (tiempoMaximo > 0) {
            double creacionCliente = rnd.nextDouble() * 1;
            System.out.println(creacionCliente);
            try {
                if (creacionCliente >= 0.5) {

                    //System.out.println(creacionCliente);
                    System.out.println("¡¡Hay un nuevo cliente!!");
                    System.out.println(" ");
                    Cliente c= new Cliente(generarNombre(), tiempoMaximo, i);
                    imprenta.anadirCliente(c);
                    util.TmEnServicio(c);
                    System.out.println("El cliente es: "+c.toString());
                    i++;
                    //System.out.println(imprenta.eliminarCliente().toString());
                    //crear cliente
                    //Cliente("Angel", 12);
                    sleep(2000);
                    tiempoMaximo -= 2;
                }
                else{
                    sleep(2000);
                    tiempoMaximo -= 2;
                }
                if (imprenta.isEmpty() == false) {
                    
                    if (imprenta.getImpresora().isOcupada() == false) {
                        tiempoServicioAleatorio = (int) (Math.random() * (imprenta.getTiempoMax()- imprenta.getTiempoMin() + 1) + imprenta.getTiempoMin());
                        imprenta.getImpresora().setOcupada(true);
                        imprenta.getImpresora().setCliente(imprenta.eliminarCliente());
                    } 
                    else {
                        ///System.err.println("Tiempo de servicio Aleatorio: "+tiempoServicioAleatorio);
                        //System.out.println("Tiempo de servicio de cliente: "+tiempoServicioCliente);                        
                        tiempoServicioCliente+=1;
                        //System.out.println("Tiempo de servicio de cliente: "+tiempoServicioCliente);
                        //System.out.println(imprenta.getImpresora().getCliente().toString());
                        if (tiempoServicioCliente == tiempoServicioAleatorio) {
                            imprenta.getImpresora().setOcupada(false);
                            tiempoServicioCliente = 0;
                        }
                    }
                    /*System.err.println("El cliente que esta en la impresora es: "
                            + imprenta.getImpresora().getCliente().toString());*/

                }
                /**
                 * Metodo del hilo
                 */
            } catch (InterruptedException ex) {
                Logger.getLogger(Simulacion.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }
}
