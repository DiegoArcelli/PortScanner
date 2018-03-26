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
        Client c = new Client();
        GestoreLog log = new GestoreLog("log");
        int opz = 0;
        while(opz!=3){
            System.out.println("Seleziona opzione:\n1) Range di porte\n2) Porte conosciute\n3) Chiudi");
            try {
                opz = Integer.parseInt(input.readLine());
                switch(opz){
                    case 1:
                    log.scriviData();
                    c.rangePorte();
                    break;
                case 2:
                    log.scriviData();
                    c.porteConosciute();
                    break;
                }
            } catch (IOException ex) {
                Logger.getLogger(ScannerPorte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
