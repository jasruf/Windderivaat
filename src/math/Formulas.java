/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import chart.Data;
/**
 *
 * @author JASEEN
 */
public class Formulas {

    final int FEBRUARY = 1;
//    Data data = new Data("/Users/Tony/Dropbox/Prove IT/107 - Simulatie Windderivaten/test_data_wind.txt");
    private Data data;
    private int yearStart, yearEnd;
    
    private double[][] avgDayPerYear;
    private double[] avgWeek;
    private double[] avgMonth;
    private double[] avgQuarter;
    private double[][] avgMonthHour;
    
    private static int monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Formulas(Data data, int yearStart, int yearEnd) {
        this.yearStart = yearStart;
        this.yearEnd = yearEnd;

        this.data = data;
        
        this.computeAvgDay();
        this.computeAvgWeek();
        this.computeAvgMonth();
        this.computeAvgQuarter();
        this.computeAvgMonthHour();
    }

    private void computeAvgDay() {
        // Skip to start year
        final int yearFirst = 1991;


        int skipHours = 0;
        for (int i = 0; i < yearStart - yearFirst; i++) {

            // if leap-year update february
            if (isLeapyear(i)) {
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

            if (isLeapyear(i)) {
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
                    totalDay += getData().getWindSpeedArray().get(skipHours++);
                }
                avgDayPerYear[i][j] = totalDay / 24;
            }
        }
    }

    private void computeAvgWeek() {
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

    private void computeAvgMonth() {

        avgMonth = new double[12];

        double totalMonth;

        int pos;
        for (int i = 0; i < 12; i++) {
            pos = 0;
            
            totalMonth = 0;
            for (int j = 0; j < avgDayPerYear.length; j++) {
                // if leap-year
                if ((j + yearStart) % 4 == 0 && (j + yearStart) % 100 != 0) {
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

    private void computeAvgQuarter() {
        avgQuarter = new double[4];

        double totalQuarter;
        for (int i = 0; i < getAvgQuarter().length; i++) {
            totalQuarter = 0;
            for (int j = 0; j < 3; j++) {
                totalQuarter += getAvgMonth()[j + i * 3];
            }

            avgQuarter[i] = totalQuarter / 3;
        }
    }

    private void computeAvgMonthHour() {
        final int monthsInYear = 12;
        final int hoursInDay = 24;

        this.avgMonthHour = new double[monthsInYear][hoursInDay];

        double[] totalHour;
        int pos = 0;

        // Every year.
        for (int y = 0; y < yearEnd - yearStart; y++) {
            if (isLeapyear(y)) {
                monthDays[FEBRUARY] = 29;
            } else {
                monthDays[FEBRUARY] = 28;
            }

            // Compute total of every hour in month
            for (int x = 0; x < monthsInYear; x++) {
                for (int i = 0; i < monthDays[x]; i++) {

                    for (int z = 0; z < hoursInDay; z++) {
                        avgMonthHour[x][z] += getData().getWindSpeedArray().get(pos++);
                    }
                }
            }
            
            // Compute average of every hour in month
            for(int x = 0; x < monthsInYear; x++) {
                for (int z = 0; z < hoursInDay; z++) {
                        avgMonthHour[x][z] = avgMonthHour[x][z] / monthDays[x];
                    }
            }
        }
    }

    private boolean isLeapyear(int year) {
        return (year + yearStart) % 4 == 0 && (year + yearStart) % 100 != 0;
    }

    public double[] getWindSpeedArray() {
        double[] windSpeed = new double[data.getWindSpeedArray().size()];
        
        for (int i = 0; i < windSpeed.length; i++) {
            windSpeed[i] = data.getWindSpeedArray().get(i);
            
            // System.out.println(windSpeed[i]);
        }
        
        return windSpeed;
    }
    
    public Data getData() {
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

    /**
     * @return the avgMonthHour
     */
    public double[][] getAvgMonthHour() {
        return avgMonthHour;
    }
}
