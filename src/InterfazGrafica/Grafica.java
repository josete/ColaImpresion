/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Rafael Murillo Zarza
 */
public class Grafica extends JPanel {

    static public boolean linea = false;
     static Graphics2D g2;
     
    public Grafica() {
        
    }

    @Override
    public void paint(Graphics g) {
         super.paintComponent(g);
         g2 = (Graphics2D) g;
        g.drawString("Procesos", 2, 10);
        g.drawString("Tiempo", 550, 250);
        //x: arriba y: arriba; 
        //x:abajo y:abajo;
        g.drawLine(20, 10, 20, 300);
        g.drawLine(10, 250, 550, 250);

        for (int x = 0; x <= 20; x++) {
            g.drawString(Integer.toString(x), 10 + (x * 25), 263);
            g.drawLine(10 + (x * 25) + 3, 245, 10 + (x * 25) + 3, 252);

        }
        if(linea){
            g2.drawString("Prueba de pintado", 100, 100);
            g2.setColor(Color.red);
            
            //g2.fillRect(10, 10, 100, 100);
            g2.drawLine(20, 200, 100, 200);
            
        }
        
        //this.setBackground(Color.WHITE);
       repaint();
        
    }


}
