/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.Analisis;

import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *Guardar archivos
 * @author jose
 */
public class Guardar {

    public Guardar(JTextArea texto) {
        File guarda = null;
        try {
            String nombre = "";
            JFileChooser file = new JFileChooser();
            file.showSaveDialog(file);
            guarda = file.getSelectedFile();
            if (guarda != null) {

                FileWriter save = new FileWriter(guarda + ".txt");
                save.write(texto.getText());
                save.close();
                JOptionPane.showMessageDialog(null,
                        "El archivo se a guardado Exitosamente",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
                texto.setText("");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "El archivo no se ha guardado",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

}
