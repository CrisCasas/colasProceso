/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colasProcesador;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author dracored
 */
public class ColaProcesos {

    public Nodo nodo;

    ArrayList<Nodo> colaNodos = new ArrayList();

    public ArrayList<Nodo> getcolaNodos() {
        return colaNodos;
    }

    /*Agregando Nodos predeterminados*/
    public void colaNodos() {
        Nodo primerNodo = new Nodo(1234, 7, "Ginneidy León");
        colaNodos.add(primerNodo);
        Nodo segundoNodo = new Nodo(1235, 2, "Cristian Casas");
        colaNodos.add(segundoNodo);
        Nodo tercerNodo = new Nodo(1236, 1, "Radamel Falcao");
        colaNodos.add(tercerNodo);
        Nodo cuartoNodo = new Nodo(1237, 3, "Lionel Messi");
        colaNodos.add(cuartoNodo);
        Nodo quintoNodo = new Nodo(1238, 1, "Mariana Pajón");
        colaNodos.add(quintoNodo);
    }

    //Scanner leer = new Scanner(System.in);

    public void nuevoNodo(Nodo nodo) {
        colaNodos.add(nodo);
        System.out.println("Nuevo proceso en fila");
        System.out.println("" + colaNodos.get(0).getNombre());
    }

    public void rellenarNodo() {
        int idNodo = 0;
        String nombre = "";
        int numProcesos = 0;

        Nodo nuevoNodo = new Nodo(idNodo, numProcesos, nombre);

        idNodo = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número del nodo"));
        nuevoNodo.setidNodo(idNodo);

        nombre = JOptionPane.showInputDialog("Introduzca el nombre del nodo");
        nuevoNodo.setNombre(nombre);

        numProcesos = Integer.parseInt(JOptionPane.showInputDialog("Introduza la  cantidad de procesos a realizar"));
        nuevoNodo.setnumProcesadores(numProcesos);

        nuevoNodo(nuevoNodo);
    }

    public void regresarACola(ArrayList<Nodo> arrayNodos) {
        int i;
        Nodo nodoAux = arrayNodos.get(0);                          
        for (i = 0; i < arrayNodos.size()-1; i++) { 
            arrayNodos.set(i, arrayNodos.get(i + 1)); 
        }
        arrayNodos.set(arrayNodos.size()-1, nodoAux); 
    }
}
