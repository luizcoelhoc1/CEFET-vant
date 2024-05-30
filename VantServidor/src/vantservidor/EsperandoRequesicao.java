/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vantservidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class EsperandoRequesicao implements Runnable{
    private DataInputStream inputServidor;
    public EsperandoRequesicao(DataInputStream inputServidor){
        this.inputServidor = inputServidor;
    }
    
    @Override
    public void run() {
    }
    
    
}
