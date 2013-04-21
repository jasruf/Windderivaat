/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import chart.Data;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author Loki
 */
public class ChartDataset {

    public final String month[] = {
        "January", "Fabruary", "March", "April",
        "May", "June", "July", "August",
        "September", "October", "November", "December"
    };
    
    private Formulas formula;
    private Data data;
    // Windspeed in meters per second
    private HistogramDataset windspeed;
    private CategoryDataset sumWindspeedQuarter;
    private CategoryDataset sumWindspeedMonth;
    private CategoryDataset sumWindspeedWeek;
    // Average windspeed per hour per month
    private CategoryDataset avgWindspeedHourMonth;
    // Polarchart: Need to think of better name :/
    private XYDataset polarData;

    public ChartDataset(Data data) {
        this.data = data;
    }

    /**
     * Prepares data for the charts
     *
     * @param yearStart
     * @param yearEnd
     */
    public void setInterval(int yearStart, int yearEnd) {
        formula = new Formulas(data, yearStart, yearEnd);
        
        this.computeAvgWindspeedHourMonth();
        this.computeSumWindspeedWeek();
        this.computeSumWindspeedQuarter();
        this.computeSumWindspeedMonth();
        this.computePolarData();
        
        this.computeWindspeed();
    }

    // Compute histogram
    private void computeWindspeed() {
        // XYSeriesCollection histogram = new XYSeriesCollection();
        
        HistogramDataset windSpeed = new HistogramDataset();
        
        
        windSpeed.addSeries("Percentage windspeed achieved",formula.getWindSpeedArray(), 30);
        
        this.windspeed = windSpeed;
    }

    private void computeSumWindspeedQuarter() {
        DefaultCategoryDataset sumQuarter = new DefaultCategoryDataset();

        for (int i = 0; i < formula.getAvgQuarter().length; i++) {
            sumQuarter.addValue(formula.getAvgQuarter()[i], "sumQuarter", new Integer(i));
        }

        this.sumWindspeedQuarter = sumQuarter;
    }

    private void computeSumWindspeedMonth() {
        DefaultCategoryDataset sumMonth = new DefaultCategoryDataset();

        for (int i = 0; i < formula.getAvgMonth().length; i++) {
            sumMonth.addValue(formula.getAvgMonth()[i], "sumMonth", new Integer(i));
        }

        this.sumWindspeedMonth = sumMonth;
    }

    private void computeSumWindspeedWeek() {
        DefaultCategoryDataset sumWeek = new DefaultCategoryDataset();

        for (int i = 0; i < formula.getAvgWeek().length; i++) {
            sumWeek.addValue(formula.getAvgWeek()[i], "sumWeek", new Integer(i));
        }

        this.sumWindspeedWeek = sumWeek;
    }

    private void computeAvgWindspeedHourMonth() {
        DefaultCategoryDataset windSpeed = new DefaultCategoryDataset();
        
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 24; j++) {
                
                // Row month
                // Column hour
                windSpeed.addValue(formula.getAvgMonthHour()[i][j], month[i], new Integer(j).toString());
            }
            
        }
        
        this.avgWindspeedHourMonth = windSpeed;
    }

    private void computePolarData() {
        
    }

    /**
     * @return the windspeed
     */
    public JFreeChart getWindspeed() {
        JFreeChart chart = ChartFactory.createHistogram("", "", "", windspeed, PlotOrientation.VERTICAL, true, true, true);
        
        chart.getXYPlot().getDomainAxis().setRange(0.00, 30.00);
        
        return chart;
    }

    /**
     * @return the sumWindspeedQuarter
     */
    public JFreeChart getSumWindspeedQuarter() {
        JFreeChart chart = ChartFactory.createLineChart("", "", "",
                sumWindspeedQuarter, PlotOrientation.VERTICAL,
                true, true, true);
        
        ValueSummary minMax = ValueSummary.init(formula.getAvgQuarter());
        double maxY = (int)minMax.max + 1;
        double minY = (int)minMax.min;
        
        chart.getCategoryPlot().getRangeAxis().setRange(minY, maxY);
        
        return chart;
    }

    /**
     * @return the sumWindspeedMonth
     */
    public JFreeChart getSumWindspeedMonth() {
        JFreeChart chart = ChartFactory.createLineChart("", "", "",
                sumWindspeedMonth, PlotOrientation.VERTICAL,
                true, true, true);
        
        ValueSummary minMax = ValueSummary.init(formula.getAvgQuarter());
        double maxY = (int)minMax.max + 1;
        double minY = (int)minMax.min;
        
        chart.getCategoryPlot().getRangeAxis().setRange(minY, maxY);
        
        return chart;
    }

    /**
     * @return the sumWindspeedWeek
     */
    public JFreeChart getSumWindspeedWeek() {
        return ChartFactory.createLineChart("", "", "",
                sumWindspeedWeek, PlotOrientation.VERTICAL,
                true, true, true);
    }

    /**
     * @return the avgWindspeedHourMonth
     */
    public JFreeChart getAvgWindspeedHourMonth() {
        JFreeChart chart = ChartFactory.createLineChart("", "", "",
                avgWindspeedHourMonth, PlotOrientation.VERTICAL,
                true, true, true);
        
        ValueSummary minMax = ValueSummary.init(formula.getAvgMonthHour());
        double maxY = (int)minMax.max + 1;
        double minY = (int)minMax.min;
        
        chart.getCategoryPlot().getRangeAxis().setRange(minY, maxY);
        
        return chart;
    }

    /**
     * @return the polarData
     */
    public JFreeChart getPolarData() {
        return ChartFactory.createPolarChart("", polarData, true, true, true);
    }
}