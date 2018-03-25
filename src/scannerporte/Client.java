/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scannerporte;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Client {
    
    private String address;
    private Socket connection;
    private int port;

    public Client(String address, int port) {
        this.address = address;
        this.port = port;
    }
    
    
    public void connetti(){
        try {
            //apro la connessione con il server sulla porta specificata
            connection = new Socket();
            connection.connect(new InetSocketAddress(address,port));
            System.out.println("\u001B[32m" + "Connessione aperta con " + connection.getRemoteSocketAddress() + "\u001B[0m");
            connection.close();
        }
        catch(ConnectException e){
            System.err.println("Server non disponibile sulla porta " + port);
        }
        catch(UnknownHostException e1){
            System.err.println("Errore DNS!");
        }
        catch(IOException e2){
            System.err.println(e2);
            e2.printStackTrace();
        }
    }
    
}
