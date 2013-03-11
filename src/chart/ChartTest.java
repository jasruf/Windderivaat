/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chart;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.WindDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
//import org.jfree.util.Rotation;
/**
 *
 * @author Loki
 */
public class ChartTest extends JFrame {
    JLayeredPane jLayer;
    ChartTest(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jLayer = new JLayeredPane();
        this.setLayout(new BorderLayout());
        this.add(jLayer, BorderLayout.CENTER);

        //jLayer.setB
        // This will create the dataset 
        IntervalXYDataset dataset = createDataset();
        
        // based on the dataset we create the chart
        JFreeChart chart = ChartFactory.createHistogram(
                "Shit", "Supershit", "megaShit", dataset, PlotOrientation.VERTICAL, true, false, false);
        // we put the chart into a panel
        
        ChartPanel chartPanel = new ChartPanel(chart);
        
        chartPanel.setBounds(0, 0, 600, 270);

        // add it to our application
        jLayer.add(chartPanel);
        setContentPane(jLayer);
        
        setPreferredSize(new java.awt.Dimension(600, 400));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ChartTest demo = new ChartTest("Comparison", "Which operating system are you using?");
        demo.pack();
        demo.setVisible(true);
    }
    
    /**
     * Creates a sample dataset 
     */

    private  HistogramDataset createDataset() {
        return createHistogramDataset();
    }
    
    private HistogramDataset createHistogramDataset() {
        double[] dummyVal = { 0.0, 0.5, 0.5 };
        
        HistogramDataset histogram = new HistogramDataset();
        
        histogram.setType(HistogramType.RELATIVE_FREQUENCY);
        histogram.addSeries("H1", dummyVal, 4, 0, 1);
        
        return histogram;
    }
    /**
     * Creates an Average dataset.
     * @return An average dataset.
     */
    private XYDataset createAvgDataset() {    
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
    private JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart chart = ChartFactory.createPolarChart("", dataset, true, true, false); 
        final PolarPlot plot = (PolarPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setAngleGridlinePaint(Color.BLACK);
        plot.setRadiusGridlinePaint(Color.LIGHT_GRAY);

        final DefaultPolarItemRenderer renderer = (DefaultPolarItemRenderer) plot.getRenderer();
        return chart;
    }
}
