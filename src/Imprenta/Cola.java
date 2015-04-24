/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Imprenta;

import Funcionalidad.Cliente;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author PC-Portatil
 */
public class Cola{
    
    Queue<Cliente> cola = new LinkedList<>();
    
    public void anadirCliente(Cliente c){
        cola.add(c);
    }
    
    public Cliente eliminarCliente(){
        return cola.remove();
    }
    
    public boolean isEmpty(){
      return cola.isEmpty();
    }
    
    public Cliente getCliente(){
        return cola.element();
    }
 
}
