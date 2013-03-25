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
    double[][] avgDayPerYear;
    double[] avgWeek;
    double[] avgMonth;
    double[] avgYear;
    int monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Formulas(Data data, int yearStart, int yearEnd) {
        this.yearStart = yearStart;
        this.yearEnd = yearEnd;

        this.data = data;
    }

    public void computeAvgDay() {
        final int FEBRUARY = 1;
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
                skipHours += monthDays[j]*24;
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
    }
/*
    public void computeAvgMonth() {

        avgMonth = new double[12];

        double totalMonth = 0;

        int day = 0;
        for (int i = 1; i < 12; i++) {
            for (int j = day; j < monthDays[i] + day; j++) {
                totalMonth += avgDay[j];
            }
            day += monthDays[i];
            avgMonth[i] = totalMonth / monthDays[i];
        }

        for (int i = 0; i < avgMonth.length; i++) {
            System.out.println(avgMonth[i]);
        }
    }
*/
    Data getData() {
        return data;
    }

    void setData(Data data) {
        this.data = data;
    }
}
