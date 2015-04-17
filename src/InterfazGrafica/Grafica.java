/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import Funcionalidad.Cliente;
import Funcionalidad.UtilidadesTiempo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Rafael Murillo Zarza
 */
public class Grafica extends JPanel {

    static public boolean inicio = false;
    static Graphics2D g2;
    public static Font fuente = new Font("Comic Sans MS", Font.BOLD, 15);
    public static Font fuente2 = new Font("Roman", Font.PLAIN, 12);

    public Grafica() {

    }

    @Override
    public void paint(Graphics g) {

        super.paintComponent(g);
        g2 = (Graphics2D) g;

        //dibujoGrafica();

        dibujoTabla();

        if (inicio) {
            dibujoInicioSimulacion();
        }

        repaint();

    }

    public void dibujoInicioSimulacion() {
        g2.setFont(fuente2);
        
        //Si hay cliente se pinta
        if (!Funcionalidad.UtilidadesTiempo.clientes.isEmpty()) {
            //g.drawLine(40, 360, 500, 360);
            dibujoCliente();
        }
        //Se dibuja la grafica
       /* int distancia = 540 / Funcionalidad.UtilidadesTiempo.getTiempoMaximoGrafica();// linea "X" distancia entre timepos
        for (int x = 1; x <= Funcionalidad.UtilidadesTiempo.getTiempoMaximoGrafica(); x++) {
            //Mayor de 30 solo pinta de 10 en 10
            if (Funcionalidad.UtilidadesTiempo.getTiempoMaximoGrafica() > 30) {
                if (x % 10 == 0) {
                    g2.drawString(Integer.toString(x), 10 + (x * distancia), 263);
                }
            } else {
                g2.drawString(Integer.toString(x), 10 + (x * distancia), 263);
            }
            //Dibuja la linea
            g2.drawLine(17 + (x * distancia) + 3, 245, 17 + (x * distancia) + 3, 252);
            //repinta parte de abajo
            Datos.repintarDatos();
        }
//        g2.drawString("Prueba de pintado", 100, 100);
//        g2.setColor(Color.red);
//        g2.drawLine(20, 200, 100, 200);
*/
    }

    public void dibujoGrafica() {
        //Base de la grafica, linea X Y y su definicion
        g2.drawString("Nº Cliente", 2, 9);
        g2.drawString("Tiempo", 550, 280);
        //x: arriba y: arriba; 
        //x:abajo y:abajo;
        g2.drawLine(20, 10, 20, 270);
        g2.drawLine(10, 250, 580, 250);
        g2.drawString(Integer.toString(0), 10, 263);
        
    }

    public void dibujoTabla() {
        g2.setColor(Color.black);

        //+610,-310,+610,-310
        g2.drawLine(650, 10, 1110, 10);
        g2.drawLine(650, 40, 1110, 40);
        //g2.drawLine(650, 500, 1110, 500);

        //Linea horizontal arriba
        g2.drawLine(40, 0, 590, 0);
        //Linea horizontal abajo
        g2.drawLine(40, 500, 590, 500);
        //Linea horizontal 2 (divisor)
        g2.drawLine(40, 30, 590, 30);

        g2.drawLine(40, 0, 40, 500);
        g2.drawLine(110, 0, 110, 500);
        g2.drawLine(260, 0, 260, 500);
        g2.drawLine(390, 0, 390, 500);
        g2.drawLine(500, 0, 500, 500);
        g2.drawLine(590, 0, 590, 500);
        
        
        g2.setFont(fuente);
        g2.setColor(Color.GREEN);
        g2.drawString("Clientes", 50, 15);
        g2.drawString("Tiempo en Servicio", 120, 15);
        g2.drawString("Tiempo en Cola", 270, 15);
        g2.drawString("Tiempo Total", 400, 15);
        g2.drawString("Atendido", 510, 15);
        
        
        g2.drawString("Clientes", 660, 30);
        g2.drawString("Tiempo en Servicio", 730, 30);
        g2.drawString("Tiempo en Cola", 880, 30);
        g2.drawString("Tiempo Total", 1010, 30);
        g2.drawString("Atendido", 1240, 30);
        

        g2.setColor(Color.RED);
        g2.drawString("Tiempo Media Total Espera", 50, 520);
        g2.drawString("Tiempo Medio Total Servicio", 50, 540);
        g2.drawString("Tiempo Medio Total del sistema", 50, 560);

    }

    public void dibujoCliente() {
      g2.setFont(fuente2);
        int n;
        //Pintar contenido de la tabla y ampliarla si es necesario
        for (int x = 0, eje_y1 = 0,eje_y2 = 0, i = 1, j = 0; x < UtilidadesTiempo.clientes.size(); x++, eje_y1 = eje_y1 + 2, i++,j++) {
            g2.setColor(Color.BLACK);
            if (eje_y1 > 20) {
            GUI.f.setSize(1200, 700);
                GUI.f.setLocationRelativeTo(null);
                g2.drawString(""+UtilidadesTiempo.clientes.get(j).getnumero(), 652, 55 + (eje_y2 * 6));
                g2.drawString(UtilidadesTiempo.clientes.get(j).getNombre(), 670, 55 + (eje_y2 * 6));
                g2.drawString(""+UtilidadesTiempo.clientes.get(j).getMomentoEntradaCola(), 780, 55 + (eje_y2 * 6));
                eje_y2 += 2;
            } else {
                g2.drawString(""+UtilidadesTiempo.clientes.get(j).getnumero(), 42, 42 + (eje_y1 * 6));
                g2.drawString(UtilidadesTiempo.clientes.get(j).getNombre(), 62, 42 + (eje_y1 * 6));
                g2.drawString(""+UtilidadesTiempo.clientes.get(j).getMomentoEntradaCola(), 172, 42 + (eje_y1 * 6));
            }
            if (UtilidadesTiempo.clientes.size() < 50) {
                n = 20;
            } else {
                n = 10;
            }
            //g2.drawString("" + i, 3, 240 - (x * n));
        }
       

    }

}
