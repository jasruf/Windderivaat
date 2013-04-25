/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

/**
 * Create summary of min and max values of array.
 *
 * @author loki
 */
public class ValueSummary {

    public double min, max;

    ValueSummary(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public static ValueSummary init(double[] array) {
        double min = array[0], max = array[0];

        for (double value : array) {
            min = value < min ? value : min;
            max = value > max ? value : max;
        }

        return new ValueSummary(min, max);
    }

    public static ValueSummary init(double[][] values) {
        double min = values[0][0], max = values[0][0];

        for (double[] array : values) {
            for (double value : array) {
                min = value < min ? value : min;
                max = value > max ? value : max;
            }
        }

        return new ValueSummary(min, max);
    }
}
