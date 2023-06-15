/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.Analisis;

import java.util.ArrayList;

/**
 *
 * @author jose
 */
public class Token {

    private String tipo;
    private int estado;
    private int fila;
    private String lexema;
    private int lenguaje;
    private ArrayList<String> proceso;

    public Token(int estado, int fila, String lexema, int lenguaje, ArrayList<String> proceso) {
        this.proceso = proceso;
        this.lenguaje = lenguaje;
        this.estado = estado;
        this.fila = fila;
        this.lexema = lexema;
        /*
        Verifica el tipo de token en base al estado final y el lenguaje final
        */
        switch (estado) {
            case 2:
                tipo = "Identificador";
                break;
            case 3:
                tipo = "Entero";
                break;
            case 4:
                tipo = "Decimal";
            case 5:
                switch (lenguaje) {
                    case 3:
                        tipo = "Puntuacion";
                        break;
                    case 4:
                        tipo = "Operacion";
                        break;
                    case 5:
                        tipo = "Agrupacion";
                        break;
                }
                break;

        }
    }

    @Override
    public String toString() {
        return "Token: " + tipo + "   Fila: " + fila + "   Lexema: " + lexema + "   \nProceso";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(int lenguaje) {
        this.lenguaje = lenguaje;
    }

    public ArrayList<String> getProceso() {
        return proceso;
    }

    public void setProceso(ArrayList<String> proceso) {
        this.proceso = proceso;
    }

}
