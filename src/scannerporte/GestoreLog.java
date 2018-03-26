/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scannerporte;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class GestoreLog {
    
    private BufferedWriter bw;
    private FileWriter fw;
    private String nomeFile;
    
    public GestoreLog(String nomeFile){
        this.nomeFile = nomeFile;
        bw = null;
        fw = null;
    }
    
    public void scriviLog(String text){
        try {
            fw = new FileWriter(nomeFile,true);
            bw = new BufferedWriter(fw);
            bw.append(text);
        } catch (IOException ex) {
            Logger.getLogger(GestoreLog.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(GestoreLog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void scriviData(){
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            fw = new FileWriter(nomeFile,true);
            bw = new BufferedWriter(fw);
            bw.append("\r\n" + dateFormat.format(date) + ":\r\n");
        } catch (IOException ex) {
            Logger.getLogger(GestoreLog.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(GestoreLog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
