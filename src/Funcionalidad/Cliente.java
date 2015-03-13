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
public class Cliente {

    private String Nombre;
    private int numero;
    int momentoEntradaCola;
    int momentoEntradaServicio;

    public Cliente(String Nombre, int momentoEntradaCola,int num) {
        this.Nombre = Nombre;
        this.numero = num;
        this.momentoEntradaCola=momentoEntradaCola;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getnumero() {
        return numero;
    }

    public void setnumero(int numero) {
        this.numero = numero;
    }
}
