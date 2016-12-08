/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lz77;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Javier
 */
public class LZ77 {
    public static int SLIDER_SIZE = 2048;
    public static int ENTRY_SIZE = 32;    
    
    
    public void createMaps(){
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StringBuffer encoded = new StringBuffer(); //The whole file coded
        StringBuffer binary_encoded = new StringBuffer();
        File file = new File("binary.txt");
        BufferedReader reader;
        String slider;
        String entry;
        
        /*Test if SLIDER_SIZE is bigger than ENTRY_SIZE */
        if (ENTRY_SIZE > SLIDER_SIZE){
            int aux = SLIDER_SIZE;
            SLIDER_SIZE = ENTRY_SIZE;
            ENTRY_SIZE = aux;
        }if( (SLIDER_SIZE%2 != 0) || (ENTRY_SIZE%2 != 0)){
            SLIDER_SIZE = 8;
            ENTRY_SIZE = 4;
        }
        
        int Mdes = (int) (Math.log(SLIDER_SIZE)/Math.log(2));
        int Ment = (int) (Math.log(ENTRY_SIZE)/Math.log(2));
                
        try {
            reader = new BufferedReader(new FileReader(file));
            String text = reader.readLine(); 
            int size = text.length();
            
            char nextSimbol;
            String match;
            int matchIndx;
            int currIndx;
            int matchLenght;
            String strIndx;
            String strLenght;
            boolean stop;
            
            encoded.append(text.substring(0, SLIDER_SIZE));//From x to y-1)
            binary_encoded.append(text.substring(0, SLIDER_SIZE)+" ");
            int pos = 0;
            // While there are characters
            while ( pos <= size-SLIDER_SIZE-ENTRY_SIZE ){                
                slider = text.substring(pos, pos+SLIDER_SIZE);//From x to y-1
                entry = text.substring(pos+SLIDER_SIZE, pos+SLIDER_SIZE+ENTRY_SIZE); 
                
                //System.out.println("Slider :"+ slider);
                //System.out.println("Entrada :"+ entry);
                
                /*Restart values*/ 
                match = "";
                matchIndx = 0;
                matchLenght = 0;
                stop = false;
                /*Finds the match*/
                while (matchLenght<ENTRY_SIZE && !stop){
                    nextSimbol = entry.charAt(matchLenght);
                    currIndx = slider.indexOf(match + nextSimbol);
                    
                    //System.out.println(currIndx);
                    if ( currIndx == -1 ){
                        stop = true;
                    }else{
                        match = match + nextSimbol;
                        matchIndx= currIndx;
                        matchLenght++;
                    }
                }
                if (matchLenght != 0){
                    //Save in alpha-numeric format
                    match = "("+matchLenght+","+(SLIDER_SIZE-matchIndx)+")";
                    encoded.append(match);
                    
                    //Save in binary format
                    strLenght = Integer.toBinaryString(matchLenght);
                    strIndx = Integer.toBinaryString(SLIDER_SIZE-matchIndx);
                    while(strLenght.length() < Ment){
                        strLenght = "0"+strLenght;
                    }
                    while(strIndx.length() < Mdes){
                        strIndx = "0"+strIndx;
                    }
                    strLenght = strLenght.substring(strLenght.length() - Ment);
                    strIndx = strIndx.substring(strIndx.length() - Mdes);
                    binary_encoded.append(strLenght+" "+strIndx+" ");
                    
                    pos = pos + matchLenght;
                }else{
                    //Save in alpha-numeric format
                    encoded.append(entry.charAt(0));
                    
                    //Save in binary Format
                    binary_encoded.append(entry.charAt(0)+" ");
                    
                    pos++;
                }
                
            }
            int trash = size - SLIDER_SIZE - pos;
            if (trash > 0){
                encoded.append(text.substring(size-trash,size));
                
                binary_encoded.append(text.substring(size-trash,size));
            }
            
            System.out.println("String: "+ encoded);
            System.out.println("Binary: "+ binary_encoded);
            
            System.out.println("Original size: "+ size);
            System.out.println("Binary size: "+ binary_encoded.length());
            System.out.println("Compress factor:" + (size/(float)binary_encoded.length()) );
            
        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
        
}
