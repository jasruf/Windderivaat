/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chart;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/**
 *
 * @author Tony
 */
public class parseData {
     public static void getData() throws FileNotFoundException, IOException {
            final int skipLines = 22;
        final int skipCommas = 4;
        final int skipDate = 11;
        int countLine = 0;
        int countComma = 0;
        int countDate = 0;
        String date;
        String data = "";
        String fileName = "/Users/Tony/Dropbox/Prove IT/107 - Simulatie Windderivaten/test_data_wind.txt";
        Date dateTime = new Date();
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        DataInputStream dis = new DataInputStream(fis);
        BufferedReader br = new BufferedReader(new InputStreamReader(dis));
        if (!file.exists()) {
            System.out.println("I can't find the file: " + fileName);
        }

        for (int i = 0; i < skipLines; i++) {
        br.readLine();
        }
              
        while (((data = br.readLine()) != null)) {
            
            
        }
        
        dis.close();
        
        
//        int i;
//        for (i = 0; i < data.length(); i++) {//Skiping text 
//          
//            if (countLine <= skipLines) {
//
//                break;
//            }
//            if (data.charAt(i) == '\n') {
//              
//                countLine++;     
//            }  
//        }
//        
//        for (; i < data.length(); i++) {// taking the date 
//        date = data.substring(i, i+10);
//            System.out.println(date);
//         
//
//
//        }
//        
//        if (countcommas >= countcommas) {// skiping commas 
//                break;
//            }
//            if (data.charAt(i) == ',') {
//                countcommas++;
//            }



    }
}
