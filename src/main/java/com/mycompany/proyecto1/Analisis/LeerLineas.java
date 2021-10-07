/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.Analisis;

import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *Lee y verifica linea por linea 
 * @author jose
 */
public class LeerLineas {

    private JTextArea texto;
    private String[] lineas;
    private ArrayList<Error> errores;
    private ArrayList<Token> tokens;
    private Estados nuevo;

    public LeerLineas(String[] lineas, JTextArea texto) {
        this.texto = texto;
        this.lineas = lineas;
        tokens = new ArrayList<>();
        errores = new ArrayList<>();
        texto.setText("");
    }

    public void analizar() {
        for (int i = 0; i < lineas.length; i++) {
            nuevo = new Estados(lineas[i], (i + 1), this, texto);
            texto.append("\n");
        }
    }

    public String[] getLineas() {
        return lineas;
    }

    public void setLineas(String[] lineas) {
        this.lineas = lineas;
    }

    public ArrayList<Error> getErrores() {
        return errores;
    }

    public void setErrores(ArrayList<Error> errores) {
        this.errores = errores;
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public void setTokens(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    public Estados getNuevo() {
        return nuevo;
    }

    public void setNuevo(Estados nuevo) {
        this.nuevo = nuevo;
    }

}
