/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysequence;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import static java.lang.Math.random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier
 */
public class BinarySequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StringBuffer sequency = new StringBuffer();
        
        for (int i=0; i<1000000; i++){
            String s = String.valueOf(Math.round(Math.random()));
            sequency.append(s);
        }
        
        System.out.println(sequency);
        PrintWriter writer;
        try {
            writer = new PrintWriter("binary.txt", "UTF-8");
            writer.println(sequency);
            writer.close();       
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BinarySequence.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(BinarySequence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
