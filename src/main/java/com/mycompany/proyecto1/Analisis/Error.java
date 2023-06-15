/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.Analisis;

/**
 *
 * @author jose
 */
public class Error {

    private int fila;
    private int columna;
    private String tipo;
    private char lexema;
    private String error;
    private int estadoAnterior;
    private String recuperacion;

    public Error(int fila, int columna, char lexema, String error, int estadoAnterior) {
        this.fila = fila;
        this.columna = columna;
        this.lexema = lexema;
        this.error = error;
        this.estadoAnterior = estadoAnterior;
        tipoError();
    }

    public void tipoError() {
        switch (estadoAnterior) {
            case 4:
                tipo = "Se espera un numero";
                break;
            case 2:
                tipo = "Se esperaba un numero o una letra";
                break;
            case 5:
                tipo = "Unica entrada";
                break;
            case 3:
                tipo = "Se esperaba un numero o un .";
                break;
        }
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public char getLexema() {
        return lexema;
    }

    public void setLexema(char lexema) {
        this.lexema = lexema;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(int estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    @Override
    public String toString() {
        return "Error--->   " + "Fila: " + fila + "   Columna: " + columna + "   Tipo: " + tipo + "   Lexema:" + lexema + "   Error: " + error + "\n";
    }

    public String getRecuperacion() {
        return recuperacion;
    }

}
