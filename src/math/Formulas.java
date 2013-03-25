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

    final int FEBRUARY = 1;
//    Data data = new Data("/Users/Tony/Dropbox/Prove IT/107 - Simulatie Windderivaten/test_data_wind.txt");
    Data data;
    int yearStart, yearEnd;
    double[][] avgDayPerYear;
    private double[] avgWeek;
    private double[] avgMonth;
    private double[] avgQuarter;
    
    int monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Formulas(Data data, int yearStart, int yearEnd) {
        this.yearStart = yearStart;
        this.yearEnd = yearEnd;

        this.data = data;
    }

    public void computeAvgDay() {
        // Skip to start year
        final int yearFirst = 1991;


        int skipHours = 0;
        for (int i = yearFirst; i < yearStart; i++) {

            // if leap-year update february
            if (i % 4 == 0 && i % 100 != 0) {
                monthDays[FEBRUARY] = 29;
            } else {
                monthDays[FEBRUARY] = 28;
            }

            for (int j = 0; j < 12; j++) {
                skipHours += monthDays[j] * 24;
            }
        }

        // Initialise avgDayPerYear
        avgDayPerYear = new double[yearEnd - yearStart][];
        for (int i = 0; i < yearEnd - yearStart; i++) {
            int daysInYear;

            // if leap-year
            if (i % 4 == 0 && i % 100 != 0) {
                daysInYear = 366;
            } else {
                daysInYear = 365;
            }

            avgDayPerYear[i] = new double[daysInYear];
        }

        double totalDay;
        for (int i = 0; i < avgDayPerYear.length; i++) {
            for (int j = 0; j < avgDayPerYear[i].length; j++) {
                totalDay = 0;
                for (int z = 0; z < 24; z++) {
                    totalDay += data.getWindSpeedArray().get(skipHours++);
                }
                avgDayPerYear[i][j] = totalDay / 24;
            }
        }
    }

    public void computeAvgWeek() {
        avgWeek = new double[52];

        double totalWeek;
        int pos = 0;
        for (int i = 0; i < getAvgWeek().length; i++) {
            totalWeek = 0;

            // Every year
            for (int j = 0; j < avgDayPerYear.length; j++) {

                // Every day
                for (int k = 0; k < 7; k++) {
                    totalWeek += avgDayPerYear[j][pos + k];
                }
            }
            avgWeek[i] = totalWeek / avgDayPerYear.length / 7;

            pos += 7;
        }
    }

    public void computeAvgMonth() {

        avgMonth = new double[12];

        double totalMonth;
        
        int pos = 0;
        for (int i = 0; i < 12; i++) {
            totalMonth = 0;
            for (int j = 0; j < avgDayPerYear.length; j++) {
                // if leap-year
                if (i % 4 == 0 && i % 100 != 0) {
                    monthDays[FEBRUARY] = 29;
                } else {
                    monthDays[FEBRUARY] = 28;
                }
                
                for (int k = 0; k < monthDays[i]; k++) {
                    totalMonth += avgDayPerYear[j][pos + k];
                }
                
                avgMonth[i] = totalMonth / avgDayPerYear.length / monthDays[i];
                
                pos += monthDays[i];
            }
        }
    }

    public void computeAvgQuarter() {
        avgQuarter = new double[4];
        
        double totalQuarter;
        for (int i = 0; i < getAvgQuarter().length; i++) {
            totalQuarter = 0;
            for (int j = 0; j < 3; j++) {
                totalQuarter += getAvgMonth()[j + i*3];
            }
            
            avgQuarter[i] = totalQuarter / 3;
        }
    }
    
    Data getData() {
        return data;
    }

    void setData(Data data) {
        this.data = data;
    }

    /**
     * @return the avgWeek
     */
    public double[] getAvgWeek() {
        return avgWeek;
    }

    /**
     * @return the avgMonth
     */
    public double[] getAvgMonth() {
        return avgMonth;
    }

    /**
     * @return the avgQuarter
     */
    public double[] getAvgQuarter() {
        return avgQuarter;
    }
}
