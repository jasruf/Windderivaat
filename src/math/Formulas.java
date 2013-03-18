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
public class Formulas {

//    Data data = new Data("/Users/Tony/Dropbox/Prove IT/107 - Simulatie Windderivaten/test_data_wind.txt");
    Data data;

    int yearStart, yearEnd;
    
    double[] avgDay;
    double[] avgMonth;
    double[] avgYear;
    
    int monthDays[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    
    public Formulas(Data data, int yearStart, int yearEnd) {
        this.yearStart = yearStart;
        this.yearEnd   = yearEnd;
        
        this.data = data;
    }

    public double[] computeAvgDay() {
        final int FEBRUARY = 1;
        // Skip to start year
        final int yearFirst = 1991;
        
        int skipDays = 0;
        for (int i = yearFirst; i < yearStart; i++) {
            
            // update february
            if(i % 4 == 0 && i % 100 != 0) {
                monthDays[FEBRUARY] = 29;
            } else {
                monthDays[FEBRUARY] = 28;
            }
            
            for (int j = 0; j < 12; j++) {
                skipDays += monthDays[j];
            }
        }
        
        int endDays = 0;
        for (int i = yearStart; i < yearEnd; i++) {
            // update february
            if(i % 4 == 0 && i % 100 != 0) {
                monthDays[FEBRUARY] = 29;
            } else {
                monthDays[FEBRUARY] = 28;
            }
          
            for (int j = 0; j < 12; j++) {
                endDays += monthDays[j];
            }
        }
        
        avgDay = new double[endDays];
        double totalDay = 0;
        for (int i = 0; i < avgDay.length; i++) {
            totalDay = 0;
            for (int j = 0; j < 24; j++) {
                totalDay += data.getWindSpeedArray().get(j+(i + skipDays)*24);
                
            }
            avgDay[i] = totalDay / 24;            
        }
        
        for (int i = 0; i < avgDay.length; i++) {
            System.out.println(avgDay[i]);
        }
        return avgDay;
    }
    
    
    
    public double[] computeAvgMonth() {
        
        avgMonth = new double[12];
        
        double totalMonth = 0;
        
        int day = 0;
        for (int i = 1; i < 12; i++) {
            for (int j = day; j < monthDays[i] + day; j++) {
                totalMonth += avgDay[j];
            }
            day += monthDays[i];
            avgMonth[i] = totalMonth / monthDays[i];
            /*if ((i%(24*12)) == 0) {
                
                avgMonth[i / 24 / 12 - 1] = totalMonth / 24 / 12;
                totalMonth = 0;
            }
            totalMonth += data.getWindSpeedArray().get(i - 1);*/
        }
        
        for (int i = 0; i < avgMonth.length; i++) {
            System.out.println(avgMonth[i]);
        }
        return avgMonth;
    }
    
    Data getData() {
        return data;
    }
    
    void setData(Data data) {
        this.data = data;
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
//            avgYear =+ data[i].speed;
//        }
//        avgYear /= 365;
//        return 0;
//    }
}
