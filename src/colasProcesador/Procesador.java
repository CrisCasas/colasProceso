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
public class Procesador {

    private String procesador;

    Timer time = new Timer();

    Procesador() {

    }

    public Procesador(String procesador) {
        this.procesador = procesador;
    }

    public void ejecutarProceso(Nodo nodo) {
        System.out.println("*-----------------*Ejecutar Proceso: " + nodo.getNombre() + " *--------------*");

        if (nodo.getnumProcesadores() <= 4) {
            while (nodo.getnumProcesadores() > 0) {

                System.out.println("Procesos faltantes # " + nodo.getnumProcesadores());
                System.out.println("Ejecutando proceso");
                time.run();
                nodo.setnumProcesadores(nodo.getnumProcesadores() - 1);
            }
        } else {
            for (int i = 0; i < 5; i++) {
                System.out.println("Procesos faltantes #" + nodo.getnumProcesadores());
                System.out.println("Ejecutando proceso");
                time.run();
                nodo.setnumProcesadores(nodo.getnumProcesadores() - 1);
            }         
        }
    }

}
