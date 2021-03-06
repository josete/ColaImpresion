/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import Funcionalidad.Simulacion;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Rafael Murillo Zarza
 */
public class Menu extends JPanel implements ActionListener, KeyListener {

    JLabel jlabelTiempoMx = new JLabel("Tiempo Simulacion (segundos) ");
    public static JTextField textTiempo = new JTextField();
    //Se inserta un boton que iniciara la simulacion
    JButton btIniciar = new JButton("Iniciar Simulacion");
    //Usaremos la clase Grafica para hacer el "dibujo" de la simulación
    Grafica g = new Grafica();
    boolean existe = true;

    public Menu() {
        //Donde se situa el panel
        super(new GridLayout(0, 3));
        Situar_Munu();
    }

    private void Situar_Munu() {
        //Añadimos el tiempo de ejecucion 
        this.add(jlabelTiempoMx);
        textTiempo.addKeyListener(this);
        this.add(textTiempo);
        //Añadimos un Action listener (Para identificar el boton y tenga una accion)
        btIniciar.addActionListener(this);
        //Lo insertamos
        this.add(btIniciar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("entro1.");
        if (Funcionalidad.UtilidadesTiempo.ExisteTiempo()) {
            Inicio();
        } else {   
            MensajeError();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
      System.out.println("entro1");
    if(e.getKeyCode()==KeyEvent.VK_ENTER ){
    if (Funcionalidad.UtilidadesTiempo.ExisteTiempo()) {
            Inicio();
        } else {
            MensajeError();
        }}
        
    
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void Inicio(){
            Funcionalidad.Simulacion.setTiempo(Integer.parseInt(textTiempo.getText()));
            Funcionalidad.UtilidadesTiempo.setTiempoMaximoGrafica(Integer.parseInt(textTiempo.getText()));
            //Cuando se pulsa el boton
            textTiempo.setEnabled(false);
            btIniciar.setEnabled(false);
            System.out.println("Boton pulsado");
            //Prueba de pintado en grafica
            g.inicio = true;
            //Iniciamo el hilo que hara de cronometo, le pasamos el TIEMPO MAXIMO que durara la simulacion.
            Simulacion s = new Simulacion(Funcionalidad.Simulacion.getTiempo());
            s.start();
        
    }
    public void MensajeError(){
            JOptionPane.showMessageDialog(null,
                    "Por favor introduzca un numero.",
                    "Numero incorrecto",
                    JOptionPane.WARNING_MESSAGE);
        
    }
}
