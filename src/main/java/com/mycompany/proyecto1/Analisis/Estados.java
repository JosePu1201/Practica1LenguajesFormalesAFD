/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.Analisis;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.text.DefaultHighlighter;

/**
 *
 * @author jose
 */
public class Estados {

    private JTextArea texto;
    private int[][] estados = new int[6][6];
    private String entrada;
    private String[] tipo;
    private int EstadoActual = 0;
    private int lenguaje = 9;
    private int fila;
    private LeerLineas arreglos;
    private int i = 0;
    private int anterior = 0;
    private int palabras = 0;

    {

    }

    public Estados(String entrada, int fila, LeerLineas arreglos, JTextArea texto) {
        this.arreglos = arreglos;
        this.texto = texto;
        this.fila = fila;
        this.entrada = entrada + " ";
        llenarMatriz();
        Verificare();
    }
/*
    Llena la matriz en base a los estados
    */
    public void llenarMatriz() { 
        estados[0][0] = 2;
        estados[1][0] = -1;
        estados[2][0] = 2;
        estados[3][0] = -1;
        estados[4][0] = -1;
        estados[5][0] = -1;

        estados[0][1] = 3;
        estados[1][1] = 4;
        estados[2][1] = 2;
        estados[3][1] = 3;
        estados[4][1] = 4;
        estados[5][1] = -1;

        estados[0][2] = -1;
        estados[1][2] = -1;
        estados[2][2] = -1;
        estados[3][2] = 1;
        estados[4][2] = -1;
        estados[5][2] = -1;

        estados[0][3] = 5;
        estados[1][3] = -1;
        estados[2][3] = -1;
        estados[3][3] = -1;
        estados[4][3] = -1;
        estados[5][3] = -1;

        estados[0][4] = 5;
        estados[1][4] = -1;
        estados[2][4] = -1;
        estados[3][4] = -1;
        estados[4][4] = -1;
        estados[5][4] = -1;

        estados[0][5] = 5;
        estados[1][5] = -1;
        estados[2][5] = -1;
        estados[3][5] = -1;
        estados[4][5] = -1;
        estados[5][5] = -1;
    }
/*
    Verifica el lenguaje en que el caracter se encuentra
    */
    public static int verificarLenguaje(char entrada, int estadoActual) {
        int retorno = -1;
        char[] Agrupacion = {'{', '}', '[', ']', '(', ')'};
        char[] operador = {'+', '-', '*', '/', '%'};
        char[] puntuaciuon = {'.', ',', ':', ';'};

        for (int i = 0; i < Agrupacion.length; i++) {
            if (Agrupacion[i] == entrada) {
                retorno = 5;
                break;
            }
        }
        for (int i = 0; i < operador.length; i++) {
            if (operador[i] == entrada) {
                retorno = 4;
                break;
            }
        }
        for (int i = 0; i < puntuaciuon.length; i++) {
            if (puntuaciuon[i] == entrada) {
                retorno = 3;
                break;
            }
        }
        if (entrada == '.' && estadoActual == 3) {
            retorno = 2;
        }
        if (Character.isDigit(entrada)) {
            retorno = 1;
        }
        if (Character.isAlphabetic(entrada) && entrada != 'ñ' && entrada != 'Ñ') {
            retorno = 0;
        }

        return retorno;

    }
    /*
    se mueve al siguiente estado
    */
    public void siguienteEstado(int actual, int lenguaje) {
        int temp = estados[actual][lenguaje];
        EstadoActual = temp;

    }
    /*
    Verifica errores 
    tokens 
    */
    public void Verificare() {

        char temp;
        String token = "";
        String pal = "";
        for (i = 0; i < entrada.length(); i++) { //busca espacios y agrega palabras
            temp = entrada.charAt(i);
            if (Character.isSpaceChar(temp)) { // si s eencuentra un espacio se evalua lo anterior 
                boolean error = false; // verifica error
                ArrayList<String> procesos = new ArrayList<>(); // guarda los procesos de transicion
                for (int j = 0; j < pal.length(); j++) {//verifica lexema por lexema
                    char temp2 = pal.charAt(j);
                    lenguaje = verificarLenguaje(temp2, EstadoActual);

                    if (EstadoActual != -1) {
                        if (lenguaje != -1) { // evita los erroes 
                            if (estados[EstadoActual][lenguaje] != -1) {
                                int a = EstadoActual + 1;
                                siguienteEstado(EstadoActual, verificarLenguaje(temp2, EstadoActual));
                                int b = EstadoActual + 1;
                                procesos.add("Paso del estado " + a + " al estado " + b + " con el caracter: " + temp2);
                                token = token + temp2;
                            } else {
                                error = true;
                                Error nuevo = new Error(fila, i, temp2, pal, EstadoActual);
                                agregar(nuevo); // Agrega los erroes a una lista
                                subrayar(pal, 1);
                                break;
                            }
                        } else {
                            Error nuevo = new Error(fila, i, temp2, pal, EstadoActual);
                            nuevo.setTipo("Caracter invalido");
                            agregar(nuevo);
                            error = true;
                            subrayar(pal, 1);
                            break;
                        }
                    } else {
                        Error nuevo = new Error(fila, i, temp2, pal, EstadoActual);
                        agregar(nuevo);
                        error = true;
                        subrayar(pal, 1);
                        break;
                    }

                }
                if (EstadoActual == 1) { // Estado de no aceptacion
                    error = true;
                    Error nuevo = new Error(fila, i, '.', pal, EstadoActual);
                    nuevo.setTipo("Se esperaba un numero");
                    agregar(nuevo);
                    subrayar(pal, 1);

                }
                if (EstadoActual == 0) {
                    error = true;
                }
                if (!error) { //Agreg el toen
                    Token nuevo = new Token(EstadoActual, fila, token, lenguaje, procesos);
                    subrayar(token, 0);
                    arreglos.getTokens().add(nuevo);
                    anterior = i + 1;
                } // reset para verificar lo que sigue en la linea
                token = "";
                EstadoActual = 0;
                lenguaje = -1;
                pal = "";
            } else {
                pal = pal + temp;

            }
        }
    }
    /*
    subraya los errores y los toens para ser mas visaul
    */
    public void subrayar(String token, int opcion) {
        Color aceptacion = Color.CYAN;
        Color error = Color.red;
        DefaultHighlighter.DefaultHighlightPainter highlightPainter = null;

        if (opcion == 0) {
            agregar(token, aceptacion);
        } else {
            agregar(token, error);
        }

    }

    public void agregar(String texto, Color color) {
        int textwidth = texto.length() * 8;
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setBounds(palabras, (fila - 1) * 16, textwidth + 10, 14);
        palabras = palabras + textwidth + 15;
        etiqueta.setForeground(color);
        this.texto.add(etiqueta);

    }

    public void agregar(Error error) {
        arreglos.getErrores().add(error);
    }

    public int[][] getEstados() {
        return estados;
    }

    public void setEstados(int[][] estados) {
        this.estados = estados;
    }

}
