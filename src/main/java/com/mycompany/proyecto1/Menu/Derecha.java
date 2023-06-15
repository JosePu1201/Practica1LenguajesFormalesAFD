/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.proyecto1.Menu;

import com.mycompany.proyecto1.Analisis.Guardar;
import com.mycompany.proyecto1.Analisis.Token;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *Grafico y llamada de metodos funcionales
 * @author jose
 */
public class Derecha extends javax.swing.JPanel {

    private panelPrincipal panel;

    /**
     * Creates new form Derecha
     */
    public Derecha(panelPrincipal panel) {
        this.panel = panel;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        errores = new javax.swing.JButton();
        tokens = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        volver = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(0, 1));

        errores.setBackground(new java.awt.Color(0, 0, 0));
        errores.setForeground(new java.awt.Color(0, 255, 255));
        errores.setText("Reporte de errores");
        errores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                erroresActionPerformed(evt);
            }
        });
        add(errores);

        tokens.setBackground(new java.awt.Color(0, 0, 0));
        tokens.setForeground(new java.awt.Color(0, 204, 204));
        tokens.setText("Reporte de tokens");
        tokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tokensActionPerformed(evt);
            }
        });
        add(tokens);

        guardar.setBackground(new java.awt.Color(0, 0, 0));
        guardar.setForeground(new java.awt.Color(0, 255, 255));
        guardar.setText("Guardar archivo");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        add(guardar);

        volver.setBackground(new java.awt.Color(0, 0, 0));
        volver.setForeground(new java.awt.Color(0, 255, 255));
        volver.setText("Regresar");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        add(volver);
    }// </editor-fold>//GEN-END:initComponents

    private void tokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tokensActionPerformed
        /*
        Solo si no hay errores
        */
        if (panel.getIzqueirda().getLectura().getErrores().size() < 1) {// recupera los erroes y muestra el proceso 
            TextoEntrada texto1 = new TextoEntrada();
            for (Token object : panel.getIzqueirda().getLectura().getTokens()) {
                texto1.getTexto().append(object.toString());
                texto1.getTexto().append("\n");
                for (String string : object.getProceso()) {
                    texto1.getTexto().append(string);
                    texto1.getTexto().append("\n");
                }
                texto1.getTexto().append("\n\n");
            }
            contador(texto1.getTexto(), panel.getIzqueirda().getLectura().getTokens());
            panel.setCentro(texto1);
            panel.agregar();
        } else {
            JOptionPane.showMessageDialog(null, "Existen errores en el texto");

        }
    }//GEN-LAST:event_tokensActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        /*
        Se regresa para editar el texto
        */
        TextoEntrada texto2 = new TextoEntrada(panel);
        for (String linea : panel.getIzqueirda().getLectura().getLineas()) {
            texto2.getTexto().append(linea + "\n");

        }
        panel.setCentro(texto2);
        JPanel nuevo = new JPanel();

        panel.agregar();

    }//GEN-LAST:event_volverActionPerformed

    private void erroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_erroresActionPerformed
        if (panel.getIzqueirda().getLectura().getErrores().size() > 0) {
            ReporteError errores = new ReporteError(panel);
            panel.setReporte(errores);
            panel.agregarTabala();

        } else {
            JOptionPane.showMessageDialog(null, "No hay errores en el archivo");
        }
    }//GEN-LAST:event_erroresActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        JTextArea texto2 = new JTextArea();
        for (String linea : panel.getIzqueirda().getLectura().getLineas()) {
            texto2.append(linea + "\n");
        }
        Guardar guardar = new Guardar(texto2);
    }//GEN-LAST:event_guardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton errores;
    private javax.swing.JButton guardar;
    private javax.swing.JButton tokens;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables

    public panelPrincipal getPanel() {
        return panel;
    }

    public void setPanel(panelPrincipal panel) {
        this.panel = panel;
    }

    public void invisible() {
        errores.setVisible(false);
        guardar.setVisible(false);
        tokens.setVisible(false);
        volver.setVisible(false);

    }

    public void contador(JTextArea area, ArrayList<Token> toknes) {
        int tipos[] = new int[6];
        String tiposLetras[] = {"Identificador", "Entero", "Decimal", "Puntuacion", "Operacion", "Agrupacion"};
        for (int i = 0; i < tipos.length; i++) {
            tipos[i] = 0;
        }
        for (Token a : toknes) {
            switch (a.getTipo()) {
                case "Identificador":
                    tipos[0] = tipos[0] + 1;
                    break;
                case "Entero":
                    tipos[1] = tipos[1] + 1;
                    break;
                case "Decimal":
                    tipos[2] = tipos[2] + 1;
                    break;
                case "Puntuacion":
                    tipos[3] = tipos[3] + 1;
                    break;
                case "Operacion":
                    tipos[4] = tipos[4] + 1;
                    break;
                case "Agrupacion":
                    tipos[5] = tipos[5] + 1;
                    break;
            }
        }
        area.append("\nCantidad de tokens\n");
        for (int i = 0; i < tipos.length; i++) {
            area.append(tiposLetras[i] + " = " + tipos[i] + "\n");
        }

    }
}
