/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chart;

import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author Loki
 */
public class ChartViewer extends JPanel {
    final int chartWidth = 300;
    final int chartHeight = 200;
    
    private ChartPanel polarChart;
    private ChartPanel sumWindspeedWeek;
    private ChartPanel sumWindspeedMonth;
    private ChartPanel sumWindspeedQuarter;
    private ChartPanel histogram;
    private ChartPanel avgWindspeed;
    
    private JLayeredPane jLayer;
    ChartViewer(XYDataset polarData, HistogramDataset histogramData,
            CategoryDataset sumWindspeedWeekData, CategoryDataset sumWindspeedMonthData,
            CategoryDataset sumWindspeedQuarterData, CategoryDataset avgWindspeedData) {
        jLayer = new JLayeredPane();
        
        this.setLayout(new BorderLayout());
        this.add(jLayer, BorderLayout.CENTER);
        
        JFreeChart polar = ChartFactory.createPolarChart("", polarData, true, true, true);
        JFreeChart sumWindspeedWeekChart = ChartFactory.createLineChart("a", "", "", 
                sumWindspeedWeekData, PlotOrientation.VERTICAL,
                true, true, true);
        
        JFreeChart sumWindspeedMonthChart = ChartFactory.createLineChart("b", "", "", 
                sumWindspeedMonthData, PlotOrientation.VERTICAL,
                true, true, true);
        
        JFreeChart sumWindspeedQuarterChart = ChartFactory.createLineChart("c", "", "", 
                sumWindspeedQuarterData, PlotOrientation.VERTICAL,
                true, true, true);
        
        JFreeChart avgWindspeedChart = ChartFactory.createLineChart("d", "", "", 
                avgWindspeedData, PlotOrientation.VERTICAL,
                true, true, true);
        
        JFreeChart histogramChart = ChartFactory.createHistogram("e", "", "",
                histogramData, PlotOrientation.VERTICAL,
                true, true, true);
        
        polarChart = new ChartPanel(polar);
        
        avgWindspeed = new ChartPanel(sumWindspeedWeekChart);
        
        sumWindspeedQuarter = new ChartPanel(sumWindspeedMonthChart);
        sumWindspeedMonth = new ChartPanel(sumWindspeedQuarterChart);
        sumWindspeedWeek = new ChartPanel(avgWindspeedChart);
        histogram = new ChartPanel(histogramChart);
        
        sumWindspeedWeek.setBounds(0, 0, chartWidth, chartHeight);
        polarChart.setBounds(chartWidth, 0, chartWidth, chartHeight);
        sumWindspeedMonth.setBounds(0, chartHeight, chartWidth, chartHeight);
        avgWindspeed.setBounds(chartWidth, chartHeight, chartWidth, chartHeight);
        sumWindspeedQuarter.setBounds(0, chartHeight*2, chartWidth, chartHeight);
        histogram.setBounds(chartWidth, chartHeight*2, chartWidth, chartHeight);
        
        jLayer.add(polarChart);
        jLayer.add(avgWindspeed);
        jLayer.add(histogram);
        jLayer.add(sumWindspeedQuarter);
        jLayer.add(sumWindspeedMonth);
        jLayer.add(sumWindspeedWeek);
    }
}
