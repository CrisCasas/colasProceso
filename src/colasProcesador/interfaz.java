/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colasProcesador;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author dracored
 */
public class interfaz {

//    Modelo modelo = new Modelo();
    

    public void pintarProcesador(Graphics pintar) {
        pintar.setColor(Color.BLACK);
        pintar.fillRect(70, 50, 10, 130);
        pintar.fillRect(10, 50, 70, 10);
        pintar.fillRect(10, 180, 70, 10);
       
        pintar.setColor(Color.GREEN);
        pintar.fillRect(10, 100, 50, 50);
        pintar.drawString("Asesor", 10, 90);
    }
    
    public void pintarNodo(Graphics pintar, Nodo nodo, int x, int y) {
        pintar.setColor(Color.red);
        pintar.fillRect(x, y, 60, 60);
        pintar.drawString(nodo.getNombre(), x - 15, y);

    }

    public void pintarCola(Graphics pintar, ArrayList<Nodo> fila) {
        pintarProcesador(pintar);
        dibujarProcesando(pintar, fila.get(0));
        for (int i = 1; i < fila.size(); i++) {
            if (i == 0) {
                pintarNodo(pintar, fila.get(i), 300, 60);
            } else {
                pintarNodo(pintar, fila.get(i), 250 + (110 * i), 100);
            }
        }
    }

    public void dibujarProcesando(Graphics pintar, Nodo cliente) {
        pintar.setColor(Color.yellow);
        pintar.fillRect(90, 100, 50, 50);
        pintar.setColor(Color.BLACK);
        pintar.drawString(cliente.getNombre(), 80, 90);
        pintar.setColor(Color.BLACK);
        pintar.drawString("Atendiendo a: " + cliente.getNombre() + 
                     "; número de transacciones: " + cliente.getnumProcesadores(), 10, 250);
        pintar.drawString("Bienvenido al Cajero: " + cliente.getNombre(), 400, 10);
        pintar.setColor(Color.BLACK);
    }

    public void limpiar(Graphics g) {
        g.clearRect(0, 0, 900, 280);
    }
}
