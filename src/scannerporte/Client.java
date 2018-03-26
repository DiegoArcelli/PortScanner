/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scannerporte;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
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
    GestoreLog log;

    public Client() {
        log = new GestoreLog("log");
    }
    
    
    public void connetti(String address, int port){
        String text = null;
        try {
            connection = new Socket();
            connection.connect(new InetSocketAddress(address,port),1000);
            text = "Connessione aperta con " + connection.getRemoteSocketAddress();
            System.out.println("\u001B[32m" + text + "\u001B[0m");
            connection.close();
        } catch(SocketTimeoutException e){
            text = "Timeout raggiunto sulla porta " + port;
            System.err.println(text);
        } catch(ConnectException e1){
            text = "Server non disponibile sulla porta " + port;
            System.err.println(text);
        } catch(UnknownHostException e2){
            text = "Errore DNS!";
            System.err.println(text);
        } catch(IOException e3){
            text = "Errore di I/O";
            System.err.println(text);
        } finally {
            log.scriviLog(text + "\r\n");
        }
    }
    
    public void rangePorte(){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String name = "";
        int portI = 0;
        int portF = 0;
        try {
            System.out.print("Inserisci nome host: ");
            name = input.readLine();
            System.out.print("Inserisci porta iniziale: ");
            portI = Integer.parseInt(input.readLine());
            System.out.print("Inserisci porta finale: ");
            portF = Integer.parseInt(input.readLine());
        } catch (IOException ex) {
            Logger.getLogger(ScannerPorte.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=portI;i<=portF;i++){
            this.connetti(name,i);   
        }
    }
    
    public void porteConosciute(){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String name = "";
        Client c;
        try {
            System.out.print("Inserisci nome host: ");
            name = input.readLine();
        } catch (IOException ex) {
            Logger.getLogger(ScannerPorte.class.getName()).log(Level.SEVERE, null, ex);
        }
        c = new Client();
        this.connetti(name,22);
        this.connetti(name,25);
        this.connetti(name,53);
        this.connetti(name,80);
        this.connetti(name,110);
        this.connetti(name,143);
        this.connetti(name,443);
        this.connetti(name,3306);

    }
    
    
    
}
