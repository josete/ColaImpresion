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

    private Random rnd = new Random();
    private Imprenta imprenta = new Imprenta();
    private static int tiempoMaximo;
    private UtilidadesTiempo util = new UtilidadesTiempo();
    private int probabilidad;
    private int tiempoEsperaCola;
    private int tiempoEnServicio = 0;
    private int tiempoServicioCliente;
    private int tiempoServicioAleatorio = 0;
    private int i = 0;
    private int clienteAtendido = 0;
    String[] pilaNombres = {"Pedro", "Pablo", "Rafa", "Jose", "Angel", "Cristiano", "Raúl", "Gareth", "Federico",
        "Iker", "Saúl", "Walter", "Jessie", "Roberto", "Andrea", "Lucía", "Julia", "Catalina", "Azucena",
        "Alejandro", "Álvaro", "Alberto", "Olga", "Laura",
        "Patricia", "Borja", "Marta", "Macarena", "Irina", "Armando", "Aitor", "Ester", "Jonhy", "Nicolás",
        "Fernando", "Javier", "Lorena", "Ignacio", "María", "Carmen", "Antonio", "Jesús", "Ana", "Paloma", "Miguel",
        "Jaime", "Mickey", "Mercedes", "Dolores", "Gustavo", "Sergio", "Carlos", "Paula", "Rita", ""};
    String[] pilaApellidos = {"García", "Tilla", "Cristo", "González", "Laso",
        "Nadal", "López", "Fernández", "Shaik", "Tormenta", "Castillo", "Torres", "Núñez", "Moreno", "Murillo",
        "Casillas", "Mouse", "Iglesias", "Benz", "White", "Pinkman", "Pérez", "Gómez", "Manzano", "Martínez",
        "Fuertes"};

    public String generarNombre() {

        int generado = (int) (rnd.nextDouble() * pilaNombres.length);
        int generado2 = (int) (rnd.nextDouble() * pilaApellidos.length);
        return pilaNombres[generado] + " " + pilaApellidos[generado2];
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
        int actual = 0;
        while (actual < tiempoMaximo) {
            double creacionCliente = rnd.nextDouble() * 1;
            System.out.println(creacionCliente);
            try {
                if (creacionCliente >= 0.5) {
                    Cliente c = new Cliente(generarNombre(), actual, i);
                    imprenta.anadirCliente(c);
                    util.TmEnServicio(c);
                    System.out.println("¡¡Hay un nuevo cliente!!");
                    //System.out.println(imprenta.getCliente().toString());
                    System.out.println("El cliente es: " + c.getNombre());
                    i++;
                    sleep(2000);
                    actual += 2;
                } else {
                    System.out.println("¡¡No hay nuevo cliente!! :( ");
                    sleep(2000);
                    actual += 2;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Simulacion.class.getName()).log(Level.SEVERE, null, ex);

            }
            meterUsuario(actual);
            
        }
        double a = tiempoEnServicio;
        double b = clienteAtendido;
        double c = tiempoEsperaCola;
        double mediaServicio = a/b;
        double mediaEspera = c/b;
        double d = tiempoMaximo;
        double servidorOcupado = a/d;
        System.out.println("Tiempo Medio de servicio: "+mediaServicio);
        System.out.println("Tiempo Medio de espera: "+mediaEspera);
        System.out.println("Porcetaje servidor ocupado: "+servidorOcupado*100+" %");
    }

    public void meterUsuario(int actual) {
        if (imprenta.isEmpty() == false) {
            if (imprenta.getImpresora().isOcupada() == false) {
                System.out.println("Cliente ha entrado en impresora");
                tiempoServicioAleatorio = (int) (rnd.nextDouble()* (imprenta.getTiempoMax() + imprenta.getTiempoMin())+1);
                System.out.println("El tiempo aleatorio: "+tiempoServicioAleatorio);
                imprenta.getImpresora().setOcupada(true);
                imprenta.getImpresora().setCliente(imprenta.eliminarCliente());
                imprenta.getImpresora().getCliente().setMomentoEntradaServicio(actual);
                tiempoEnServicio+=tiempoServicioAleatorio;
                    clienteAtendido++;
                    tiempoEsperaCola+=imprenta.getImpresora().getCliente().calcularTiempoDeEspera();
            } else {
                //System.out.println(imprenta.getImpresora().getCliente().toString());
                imprenta.getImpresora().getCliente().aumentarTiempoSErvicioAcual();
                if (imprenta.getImpresora().getCliente().getTiempoServicioActual() == tiempoServicioAleatorio) {
                    imprenta.getImpresora().setOcupada(false);
                    System.out.println("El cleinte ha salido de la impresora "+imprenta.getImpresora().getCliente().getNombre());
                    System.out.println(imprenta.getImpresora().getCliente().toString());
                    //tiempoServicioCliente = 0;
                }

            }
            //System.err.println(imprenta.getImpresora().getCliente().calcularTiempoDeEspera());

        }
    }
}
