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
 * @author Rafael Murillo Zarza
 */
public class Datos extends JPanel {
    //Donde se tintruduciran los datos
    static JLabel labelMaximo;
    static JLabel labelMinimo;
    static JLabel labelMedio;
    static JLabel LabelProporcionTiempoOcupado;
    
    Imprenta.Cola cola = new Cola();
   

    public Datos() {
        labelMaximo = new JLabel("Tiempo Maximo: "+ Funcionalidad.Simulacion.getTiempo());
        labelMinimo = new JLabel("Tiempo Minimo: ");
        labelMedio = new JLabel("Tiempo Medio: ");
        LabelProporcionTiempoOcupado = new JLabel("Tiempo Ocupado: ");

        this.add(labelMaximo);
        this.add(labelMinimo);
        this.add(labelMedio);
        this.add(LabelProporcionTiempoOcupado);
        
        this.setBackground(Color.ORANGE);
    }
    public static void repintarDatos(){
        
        //System.out.println("ENTROOOOOOOOOOOO? "+Funcionalidad.Simulacion.getTiempo());
        labelMaximo.setText("Tiempo Maximo: "+ Funcionalidad.Simulacion.getTiempo());
        labelMinimo.setText("Tiempo Minimo: ");
        labelMedio.setText("Tiempo Medio: ");
        
        
        }
    
    
}