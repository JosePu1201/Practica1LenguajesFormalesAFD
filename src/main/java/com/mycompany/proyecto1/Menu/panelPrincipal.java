/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1.Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class panelPrincipal extends JPanel {

    private Derecha derecha;
    private Izquierda izquierda;
    private TextoEntrada centro;
    private Patron arriba;
    private ReporteError reporte = null;

    public panelPrincipal() {

        arriba = new Patron(this);
        derecha = new Derecha(this);
        derecha.setVisible(false);
        derecha.setBackground(Color.BLACK);
        izquierda = new Izquierda(this);
        izquierda.setBackground(Color.black);
        centro = new TextoEntrada(this);
        centro.setBackground(Color.black);
        this.setBackground(Color.BLACK);
        this.setLayout(new BorderLayout());
        agregar();

    }

    public void agregar() {
        this.add(centro, BorderLayout.CENTER);
        this.add(derecha, BorderLayout.EAST);
        this.add(izquierda, BorderLayout.WEST);
        this.add(arriba, BorderLayout.NORTH);
        this.setVisible(false);
        this.setVisible(true);
    }

    public Derecha getDerecha() {
        return derecha;
    }

    public void setDerecha(Derecha derecha) {
        this.derecha.setVisible(false);
        this.derecha = derecha;
        this.derecha.setVisible(true);
    }

    public Izquierda getIzqueirda() {
        return izquierda;
    }

    public void setIzqueirda(Izquierda izqueirda) {
        this.izquierda.setVisible(false);
        this.izquierda = izqueirda;
        this.izquierda.setVisible(true);
    }

    public TextoEntrada getCentro() {
        return centro;
    }

    public void setCentro(TextoEntrada centros) {
        if (reporte != null) {
            reporte.setVisible(false);
        }
        this.centro.setVisible(false);
        this.centro = centros;
        this.centro.setVisible(true);
    }

    public Izquierda getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Izquierda izquierda) {
        this.izquierda.setVisible(false);
        this.izquierda = izquierda;
        this.izquierda.setVisible(true);
    }

    public Patron getArriba() {
        return arriba;
    }

    public void setArriba(Patron arriba) {
        this.arriba = arriba;
    }

    public ReporteError getReporte() {
        return reporte;
    }

    public void setReporte(ReporteError reporte) {
        centro.setVisible(false);
        if (this.reporte != null) {
            this.reporte.setVisible(false);
            this.reporte = reporte;
            this.reporte.setVisible(true);
        } else {
            this.reporte = reporte;
            this.reporte.setVisible(true);
        }
    }

    public void agregarTabala() {
        this.add(reporte, BorderLayout.CENTER);
        this.setVisible(false);
        this.setVisible(true);
    }

    public void AgregarAbajo() {
        this.add(centro, BorderLayout.SOUTH);
        this.setVisible(false);
        this.setVisible(true);
    }
}
