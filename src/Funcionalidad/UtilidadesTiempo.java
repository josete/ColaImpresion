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
public class UtilidadesTiempo {

    //Guadar tiempo que pasa cada cliente en servicio (Para poder calcular
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    static int tiemMaxGrafiaca;
    //Para saber si han introducido un NÚMERO ENTERO y no texto
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
    public void TmEnServicio(Cliente cliente) {
        clientes.add(cliente);
    }

    
    //Tiempo Medio de cada cliente, tiempo total partido nº de clientes
    public int TMmd() {
        int tiempoTotalServicio = 0;
        for (int x = 0; x < clientes.size(); x++) {
            //tiempoTotalServicio = tiempoTotalServicio + tiemposervicio.get(x);
        }
        int tiempoMed = tiempoTotalServicio / clientes.size();
        return tiempoMed;
    }
    //NO HACER CASO
    //Tiempo maximo, se define en la interfaz
    public static void setTiempoMaximoGrafica(int t) {
    UtilidadesTiempo.tiemMaxGrafiaca = t;
      
    }
    
    public static int getTiempoMaximoGrafica() {
    return tiemMaxGrafiaca;
      
    }
/*
    //Lo definis vosotros de forma aleatoria creo...
    public int TiempoMinimo(int t) {
        return t;
    }

    //Tiempo que pasa usuario en la cola
    public int TiempoEspera(int t) {
        return t;
    }
   */
}
