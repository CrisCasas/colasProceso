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
	public Nodo primero,ultimo;

	ArrayList<Nodo> colaNodos = new ArrayList();

	public ArrayList<Nodo> getcolaNodos() {
		return colaNodos;
	}

	/* Agregando Nodos predeterminados */
	public void colaNodos() {
		Nodo primerNodo = new Nodo(0, 7, "Copear Archivos");
		colaNodos.add(primerNodo);
		Nodo segundoNodo = new Nodo(1, 2, "Enviar archivos");
		colaNodos.add(segundoNodo);
		Nodo tercerNodo = new Nodo(2, 1, "Pintar imagen");
		colaNodos.add(tercerNodo);
		Nodo cuartoNodo = new Nodo(3, 3, "Abrir aplicación");
		colaNodos.add(cuartoNodo);
		Nodo quintoNodo = new Nodo(4, 1, "Escribir en consola");
		colaNodos.add(quintoNodo);
	}
	
	public void eliminar(int id) {
		colaNodos.remove(id);
	}


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
		for (i = 0; i < arrayNodos.size() - 1; i++) {
			arrayNodos.set(i, arrayNodos.get(i + 1));
		}
		arrayNodos.set(arrayNodos.size() - 1, nodoAux);
	}
	
	
	
	/*
	 * Scanner leer= new Scanner(System.in);
	 * 
	 * public void eliminarNodo() { Nodo actual= new Nodo(); actual = primero; Nodo
	 * anterior= new Nodo(); anterior=null; boolean encontrado=false;
	 * System.out.println("Ingrese el id del nodo a Eliminar: "); int
	 * nodoBuscado=leer.nextInt(); if(primero!=null) { while(actual !=null &&
	 * encontrado != true) { if(actual==primero) { primero=primero.siguiente; }else
	 * if(actual==ultimo) { anterior.siguiente=null; ultimo=ante } } } //int
	 * nodoBuscado=
	 * Integer.parseInt(JOptionPane.showInputDialog(null,"id del nodo a eliminar"));
	 * 
	 * }
	 */



}
