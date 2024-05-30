/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vantcliente;

import javax.swing.JLabel;

/**
 *
 * @author ASUS
 */
public class ContagemRegressiva implements Runnable {

    JLabel contador;

    public ContagemRegressiva(JLabel contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i>0; i--) { //conta ate 5
               contador.setText(String.valueOf(i));
               Thread.sleep(1000);
            }
            contador.setText("lançado!");
        } catch (InterruptedException ex) {
            
        }

    }

}
