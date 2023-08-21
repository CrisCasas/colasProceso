/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colasProcesador;

/**
 *
 * @author dracored
 */
public class Nodo {
    private int idNodo;
    private int numProcesos;
    private String nombre;

    
    public Nodo(int idNodo, int numProcesos, String nombre) {
        this.idNodo = idNodo;
        this.numProcesos = numProcesos;
        this.nombre = nombre;
    }

    public int getidNodo() {
        return idNodo;
    }

    public void setidNodo(int idNodo) {
        this.idNodo = idNodo;
    }

    public int getnumProcesadores() {
        return numProcesos;
    }

    public void setnumProcesadores(int numProcesos) {
        this.numProcesos = numProcesos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
