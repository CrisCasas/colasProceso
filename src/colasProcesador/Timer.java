/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colasProcesador;

import java.util.Scanner;
/**
 *
 * @author dracored
 */
public class Timer implements Runnable {

    int demoraProcesando;
//Scanner s = new Scanner(System.in);
    @Override
    public void run() {
        try {
            demoraProcesando = 2;
            while (demoraProcesando > 0) {
                System.out.println("" + demoraProcesando);
                Thread.sleep(1000);
                demoraProcesando -= 1;
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
