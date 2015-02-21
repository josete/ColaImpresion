/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import java.util.ArrayList;

/**
 *
 * @author Rafael Murillo Zarza
 */
//Esta clase se usara para imprimir la informacion por pantalla, realizara las operaciones.
public class Metodos {

    //Guadar tiempo que pasa cada cliente en servicio (Para poder calcular
    public static ArrayList<Integer> tiemposervicio = new ArrayList<Integer>();

    //Para saber si han introducio un NUMERO ENTERO y no texto
    public static boolean ExisteTiempo() {
        try {
            String num = InterfazGrafica.Menu.textTiempo.getText();
            int segundos = Integer.parseInt(num);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //Tiempo que pasa cliente en Servicio, al ser aleatorio se va guardando en un Arraylist. 
    public void TmEnServicio(int t) {
        tiemposervicio.add(t);
    }

    //Tiempo Medio de cada cliente, tiempo total partido nº de clientes
    public int TMmd() {
        int tiempoTotalServicio = 0;
        for (int x = 0; x < tiemposervicio.size(); x++) {
            tiempoTotalServicio = tiempoTotalServicio + tiemposervicio.get(x);
        }
        int tiempoMed = tiempoTotalServicio / tiemposervicio.size();
        return tiempoMed;
    }

    //Tiempo maximo, se define en la interfaz
    public int TiempoMaximo(int t) {
        return t;
    }

    //Lo definis vosotros de forma aleatoria creo...
    public int TiempoMinimo(int t) {
        return t;
    }

    //Tiempo que pasa usuario en la cola
    public int TiempoEspera(int t) {
        return t;
    }
}
