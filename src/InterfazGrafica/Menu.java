/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import Funcionalidad.Cliente;
import Funcionalidad.Simulacion;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class Menu extends JPanel implements ActionListener {

    JLabel jlabelNombre = new JLabel("Nombre Usuario");
    JLabel jlabelElemntos = new JLabel("Introduzca nº elementos a imprimir");
    JTextField textNombre = new JTextField();
    JTextField textElemntos = new JTextField();
    Grafica g = new Grafica();
    
    JButton btImprimir = new JButton("Imprimir");
    
public Menu(){
     super(new GridLayout(0,2));
     Situar_Munu();
}

private void Situar_Munu(){
    this.add(jlabelNombre);
    this.add(textNombre);
    this.add(jlabelElemntos);
    this.add(textElemntos);
    btImprimir.addActionListener(this);
    this.add(btImprimir);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Boton pulsado");
        //g.pintar(this.getGraphics());
        g.linea = true;
        Simulacion s = new Simulacion(10);
        s.start();
        
    }
    
}
