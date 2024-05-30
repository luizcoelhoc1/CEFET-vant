/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vantservidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class VantServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket socketDoServidor = new ServerSocket(8888); // fala que é um servidor
        ArrayList<Soquete> soquetes = new ArrayList<>();

        while (true){
            
            //abrir conexão
            Socket servidor = socketDoServidor.accept();
            Socket cliente = new Socket(servidor.getInetAddress(), 7777) ;
            soquetes.add(new Soquete(cliente, servidor));

        }
        

    }
}
