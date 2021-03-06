/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chart;


import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
//import org.jfree.util.Rotation;
/**
 *
 * @author Loki
 */
public class ChartTest {
    
    /**
     * Creates a sample dataset 
     */

    public static CategoryDataset createCategoryDataset() {
        
        // row keys...
        final String series1 = "First";
        final String series2 = "Second";
        final String series3 = "Third";

        // column keys...
        final String type1 = "Type 1";
        final String type2 = "Type 2";
        final String type3 = "Type 3";
        final String type4 = "Type 4";
        final String type5 = "Type 5";
        final String type6 = "Type 6";
        final String type7 = "Type 7";
        final String type8 = "Type 8";

        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(1.0, series1, type1);
        dataset.addValue(4.0, series1, type2);
        dataset.addValue(3.0, series1, type3);
        dataset.addValue(5.0, series1, type4);
        dataset.addValue(5.0, series1, type5);
        dataset.addValue(7.0, series1, type6);
        dataset.addValue(7.0, series1, type7);
        dataset.addValue(8.0, series1, type8);

        dataset.addValue(5.0, series2, type1);
        dataset.addValue(7.0, series2, type2);
        dataset.addValue(6.0, series2, type3);
        dataset.addValue(8.0, series2, type4);
        dataset.addValue(4.0, series2, type5);
        dataset.addValue(4.0, series2, type6);
        dataset.addValue(2.0, series2, type7);
        dataset.addValue(1.0, series2, type8);

        dataset.addValue(4.0, series3, type1);
        dataset.addValue(3.0, series3, type2);
        dataset.addValue(2.0, series3, type3);
        dataset.addValue(3.0, series3, type4);
        dataset.addValue(6.0, series3, type5);
        dataset.addValue(3.0, series3, type6);
        dataset.addValue(4.0, series3, type7);
        dataset.addValue(3.0, series3, type8);

        return dataset;
                
    }
    
    public static HistogramDataset createHistogramDataset() {
        double[] dummyVal = { 0.0, 0.0, 0.0, 0.3 ,0.5, 0.5, 0.8 };
        
        HistogramDataset histogram = new HistogramDataset();
        
        histogram.setType(HistogramType.RELATIVE_FREQUENCY);
        histogram.addSeries("H1", dummyVal, 8, 0, 1);
        
        return histogram;
    }
    /**
     * Creates an Average dataset.
     * @return An average dataset.
     */
    public static XYDataset createAvgDataset() {    
        final XYSeriesCollection data = new XYSeriesCollection();
        
        for( int x = 0; x < 8; x++) {
            XYSeries series = new XYSeries("Series"+x);
            series.add(0, 0);
            
            for( int y = 0; y < 2; y++ ) {
                series.add((x*45)+(y*45 + 45),(25*x+25)%7+19);
                
            }
            //data.setIntervalWidth(1);
            data.addSeries(series);
        }

        return data;
    } 
    
    /**
     * Creates a sample chart.
     * @param dataset  the dataset.
     * @return A sample chart.
     */
    public static JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart chart = ChartFactory.createPolarChart("", dataset, true, true, false); 
        final PolarPlot plot = (PolarPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setAngleGridlinePaint(Color.BLACK);
        plot.setRadiusGridlinePaint(Color.LIGHT_GRAY);

        final DefaultPolarItemRenderer renderer = (DefaultPolarItemRenderer) plot.getRenderer();
        return chart;
    }
}
