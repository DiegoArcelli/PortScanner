/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scannerporte;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class ScannerPorte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic her
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String dom = "";
        int portI = 0;
        int portF = 0;
        try {
            System.out.print("Inserisci dominio: ");
            dom = input.readLine();
            System.out.print("Inserisci porta d'inizio: ");
            portI = Integer.parseInt(input.readLine());
            System.out.print("Inserisci porta finale: ");
            portF = Integer.parseInt(input.readLine());
        } catch (IOException ex) {
            Logger.getLogger(ScannerPorte.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=portI;i<=portF;i++){
            Client c = new Client(dom,i);
            c.connetti();   
        }
    }
    
}
