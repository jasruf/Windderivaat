/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chart;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author Loki
 */
public class ChartViewer extends JPanel {
    private ChartPanel polarChart;
    private ChartPanel sumWindspeedWeek;
    private ChartPanel sumWindspeedMonth;
    private ChartPanel sumWindspeedQuarter;
    private ChartPanel histogram;
    private ChartPanel avgWindspeed;
    
    private JLayeredPane jLayer;
    ChartViewer(XYDataset polarData, HistogramDataset histogramData, CategoryDataset sumWindspeedWeekData) {
        jLayer = new JLayeredPane();
        
        this.setLayout(new BorderLayout());
        this.add(jLayer, BorderLayout.CENTER);
        
        JFreeChart polar = ChartFactory.createPolarChart("", polarData, true, true, true);
        
        
        
        jLayer.add(polarChart);
        jLayer.add(avgWindspeed);
        jLayer.add(histogram);
        jLayer.add(sumWindspeedQuarter);
        jLayer.add(sumWindspeedMonth);
        jLayer.add(sumWindspeedWeek);
        
        polarChart.setBounds(0, 0, 500, 600);
        avgWindspeed.setBounds(0, 0, 500, 600);
        histogram.setBounds(0, 0, 500, 600);
        sumWindspeedQuarter.setBounds(0, 0, 500, 600);
        sumWindspeedMonth.setBounds(0, 0, 500, 600);
        sumWindspeedWeek.setBounds(0, 0, 500, 600);
    }
}
