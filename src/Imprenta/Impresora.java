/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Imprenta;

import Funcionalidad.Cliente;

/**
 *
 * @author PC-Portatil
 */
public class Impresora {
    
   private boolean ocupada = false;
   private Cliente cliente;
   

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
   
    
   
}
