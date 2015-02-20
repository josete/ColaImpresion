/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imprenta;

/**
 *
 * @author PC-Portatil
 */
public class Imprenta extends Cola {

    private int tiempoMin;
    private int tiempoMax;
    private final Impresora impresora;

    public Imprenta() {
        impresora = new Impresora();
    }

    public int getTiempoMin() {
        return tiempoMin;
    }

    public void setTiempoMin(int tiempoMin) {
        this.tiempoMin = tiempoMin;
    }

    public int getTiempoMax() {
        return tiempoMax;
    }

    public void setTiempoMax(int tiempoMax) {
        this.tiempoMax = tiempoMax;
    }

}
