/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import Funcionalidad.Cliente;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Rafael Murillo Zarza
 */
public class GUI {

    private static void createAndShowGUI() {
        //SwingUtilities.isEventDispatchThread();
        JFrame f = new JFrame("Simulador Cola");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //f.setLayout(new BorderLayout());
        JPanel situacion = new JPanel();
        //situacion.setLayout(new BorderLayout());
        situacion.add(new Menu(), BorderLayout.CENTER);
        f.add(situacion, BorderLayout.NORTH);
        f.add(new InterfazGrafica.Grafica(), BorderLayout.CENTER);
        f.add(new Datos(), BorderLayout.SOUTH);
        f.pack();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });
        f.setVisible(true);
        f.setSize(600, 400);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
                
            }
        });
    }
}
