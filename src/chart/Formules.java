/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chart;

/**
 *
 * @author JASEEN
 */
public class Formules {

    Data data[];
    double avgDay=0;
    double avgMonth=0;
    double avgYear=0;

    public int avgDay() {
       
        for (int i = 0; i < data.length; i++) {

            for (int j = 0; j <= 23; j++) {

                avgDay = +data[i].speed;
            }
        }
        avgDay = avgDay / 24;
        return 0;
    }

    public int avgMonth() {

        for (int i = 0; i < 31; i++) {

            avgMonth = +avgDay;

        }
        avgMonth /= 31;
        return 0;
    }

    public double avgYear() {
        for (int i = 0; i < 365; i++) {
            avgYear = +data[i].speed;
        }
        avgYear /= 365;
        return 0;
    }
}
