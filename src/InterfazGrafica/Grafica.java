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
        g.drawString("Tiempo", 550, 280);
        //x: arriba y: arriba; 
        //x:abajo y:abajo;
        g.drawLine(20, 10, 20, 300);
        g.drawLine(10, 250, 580, 250);
        g.drawString(Integer.toString(0), 10, 263);

        if (linea) {
            int distancia = 540 / Funcionalidad.Simulacion.getTiempo();
            for (int x = 1; x <= Funcionalidad.Simulacion.getTiempo(); x++) {
                if (Funcionalidad.Simulacion.getTiempo() > 30) {
                    if (x % 2 == 0) {
                        g.drawString(Integer.toString(x), 10 + (x * distancia), 263);
                    }
                } else {
                    g.drawString(Integer.toString(x), 10 + (x * distancia), 263);
                }

                g.drawLine(17 + (x * distancia) + 3, 245, 17 + (x * distancia) + 3, 252);

            }
            g2.drawString("Prueba de pintado", 100, 100);
            g2.setColor(Color.red);

            //g2.fillRect(10, 10, 100, 100);
            g2.drawLine(20, 200, 100, 200);

        }

        //this.setBackground(Color.WHITE);
        repaint();

    }

}
