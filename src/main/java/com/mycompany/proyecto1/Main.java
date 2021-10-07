/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1;

import com.mycompany.proyecto1.Menu.Izquierda;
import com.mycompany.proyecto1.Menu.TextoEntrada;
import com.mycompany.proyecto1.Menu.panelPrincipal;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Main {

    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        panelPrincipal panel = new panelPrincipal();
        Izquierda botonesIzquierda = new Izquierda(panel);
        TextoEntrada entrada = new TextoEntrada(panel);
        panel.setIzqueirda(botonesIzquierda);
        panel.setCentro(entrada);
        panel.agregar();
        ventana.setTitle("Analizador Lexico");
        ventana.setSize(1000, 500);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana.add(panel);
        ventana.setVisible(true);

    }
}
