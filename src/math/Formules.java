/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import chart.Data;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JASEEN
 */
public class Formules {

//    Data data = new Data("/Users/Tony/Dropbox/Prove IT/107 - Simulatie Windderivaten/test_data_wind.txt");
    Data data;
    
    double avgDay = 0;
    double avgMonth = 0;
    double avgYear = 0;

    public Formules(String path) {
        try {
            data = new Data(path);
            data.fill();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Formules.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Formules.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    
//    public int avgDay() {
//
//        for (int i = 0; i <.; i++) {
//
//            for (int j = 0; j <= 23; j++) {
//
//                avgDay = +data[i].speed;
//            }
//        }
//        avgDay = avgDay / 24;
//        return 0;
//    }
//
//    public int avgMonth() {
//
//        for (int i = 0; i < 31; i++) {
//
//            avgMonth += avgDay;
//
//        }
//        avgMonth /= 31;
//        return 0;
//    }
//
//    public double avgYear() {
//        for (int i = 0; i < 365; i++) {
//            avgYear = +data[i].speed;
//        }
//        avgYear /= 365;
//        return 0;
//    }
}
