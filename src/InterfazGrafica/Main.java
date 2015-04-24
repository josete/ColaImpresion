/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfazGrafica;

import Funcionalidad.Simulacion;
import java.util.Scanner;

/**
 *
 * @author PC-Portatil
 */
public class Main {
    
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Introduce duracion");
        int duracion = in.nextInt();
        Simulacion s = new Simulacion(duracion);
        s.start();
    }
}
