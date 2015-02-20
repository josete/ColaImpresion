/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import Imprenta.Cola;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Datos extends JPanel {

    static JLabel labelMaximo;
    static JLabel labelMinimo;
    static JLabel labelMedio;
    
    Imprenta.Cola cola = new Cola();
   

    public Datos() {
        labelMaximo = new JLabel("Tiempo Maximo: ");
        labelMinimo = new JLabel("Tiempo Minimo: ");
        labelMedio = new JLabel("Tiempo Medio: ");

        this.add(labelMaximo);
        this.add(labelMinimo);
        this.add(labelMedio);

        this.setBackground(Color.WHITE);
    }
}