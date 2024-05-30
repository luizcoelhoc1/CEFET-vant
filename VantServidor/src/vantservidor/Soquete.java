package vantservidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author ASUS
 */
public class Soquete {
    private Socket cliente;
    private Socket servidor;
    private DataOutputStream outputCliente;
    private DataInputStream inputCliente;
    private DataOutputStream outputServidor;
    private DataInputStream inputServidor;
    
    public Soquete(Socket cliente, Socket servidor) throws IOException {
        this.servidor = servidor;
        this.cliente = cliente;
        this.outputCliente = new DataOutputStream(cliente.getOutputStream());
        this.inputCliente = new DataInputStream(cliente.getInputStream());
        this.outputServidor = new DataOutputStream(servidor.getOutputStream());
        this.inputServidor = new DataInputStream(servidor.getInputStream());
        Thread thread = new Thread(new EsperandoRequesicao(inputServidor));
        thread.start();
    }

    
    /**
     * @return the cliente
     */
    public Socket getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the servidor
     */
    public Socket getServidor() {
        return servidor;
    }

    /**
     * @param servidor the servidor to set
     */
    public void setServidor(Socket servidor) {
        this.servidor = servidor;
    }

    /**
     * @return the outputCliente
     */
    public DataOutputStream getOutputCliente() {
        return outputCliente;
    }

    /**
     * @param outputCliente the outputCliente to set
     */
    public void setOutputCliente(DataOutputStream outputCliente) {
        this.outputCliente = outputCliente;
    }

    /**
     * @return the inputCliente
     */
    public DataInputStream getInputCliente() {
        return inputCliente;
    }

    /**
     * @param inputCliente the inputCliente to set
     */
    public void setInputCliente(DataInputStream inputCliente) {
        this.inputCliente = inputCliente;
    }

    /**
     * @return the outputServidor
     */
    public DataOutputStream getOutputServidor() {
        return outputServidor;
    }

    /**
     * @param outputServidor the outputServidor to set
     */
    public void setOutputServidor(DataOutputStream outputServidor) {
        this.outputServidor = outputServidor;
    }

    /**
     * @return the inputServidor
     */
    public DataInputStream getInputServidor() {
        return inputServidor;
    }

    /**
     * @param inputServidor the inputServidor to set
     */
    public void setInputServidor(DataInputStream inputServidor) {
        this.inputServidor = inputServidor;
    }
    
    
    
    
}
