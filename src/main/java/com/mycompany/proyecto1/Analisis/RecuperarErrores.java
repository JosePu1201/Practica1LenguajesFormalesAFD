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
public class RecuperarErrores {

    private ArrayList<Error> erroes;
    private int[][] matriz;
    private ArrayList<String> recuperacion;

    public RecuperarErrores(ArrayList<Error> erroes, int[][] matriz) {
        this.erroes = erroes;
        this.matriz = matriz;
        recuperacion = new ArrayList<>();
        for (Error erroe : erroes) {
            verificar(erroe.getError());
        }

    }

    public ArrayList<Error> getErroes() {
        return erroes;
    }

    public void setErroes(ArrayList<Error> erroes) {
        this.erroes = erroes;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public ArrayList<String> getRecuperacion() {
        return recuperacion;
    }

    public void setRecuperacion(ArrayList<String> recuperacion) {
        this.recuperacion = recuperacion;
    }

    private void verificar(String pal) {
        String solucion = "";
        int EstadoActual = 0;
        int lenguaje = -1;
        String token = "";
        String errores = "";
        boolean error = false;
        int cant = 0;
        /*
        analiza de nuevo tokens 
        */
        for (int j = 0; j < pal.length(); j++) {
            char temp2 = pal.charAt(j);
            lenguaje = Estados.verificarLenguaje(temp2, EstadoActual);
            if (EstadoActual != -1) {
                if (lenguaje != -1) {
                    //Agrega erroes o toknes
                    if (error) {
                        token = token + temp2;
                    } else {
                        errores = errores + temp2;
                    }
                    if (matriz[EstadoActual][lenguaje] != -1) {
                        EstadoActual = siguienteEstado(EstadoActual, Estados.verificarLenguaje(temp2, EstadoActual));
                    } else {
                        error = true;
                        cant++;
                        EstadoActual = 0;
                        if (cant > 1) { // si hay mas de dos erroes el automata se detiene
                            break;
                        }
                    }
                } else {
                    error = true;
                    cant++;
                    EstadoActual = 0;
                    if (cant > 1) {
                        break;
                    }
                }
            }

        }
        if (error && cant == 1) {
            Token nuevo = new Token(EstadoActual, 0, token, lenguaje, null);
            solucion = "Error en --->" + errores + " Pero se encontro el token: " + token + " de tipo " + nuevo.getTipo();
            recuperacion.add(solucion);
        }

    }

    public void reset(int EstadoActual, int Lenguaje) {
        EstadoActual = 0;
        Lenguaje = -1;
    }

    public int siguienteEstado(int actual, int lenguaje) {
        int temp = matriz[actual][lenguaje];
        int EstadoActual = temp;
        return EstadoActual;
    }
}
