package chart;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import math.ChartDataset;
import math.Formulas;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JASEEN
 */
public class MainGUI extends javax.swing.JFrame {

    /**
     * Creates new form MainGUI
     */
    public MainGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chartViewer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout chartViewerLayout = new javax.swing.GroupLayout(chartViewer);
        chartViewer.setLayout(chartViewerLayout);
        chartViewerLayout.setHorizontalGroup(
            chartViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
        );
        chartViewerLayout.setVerticalGroup(
            chartViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(267, Short.MAX_VALUE)
                .addComponent(chartViewer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chartViewer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * @param args the command line arguments
     */
    final int chartWidth = 300;
    final int chartHeight = 200;
    private ChartPanel polarChart;
    private ChartPanel sumWindspeedWeek;
    private ChartPanel sumWindspeedMonth;
    private ChartPanel sumWindspeedQuarter;
    private ChartPanel histogram;
    private ChartPanel avgWindspeed;
    
    public void initGraphs(JFreeChart polar,
            JFreeChart sumWindspeedWeekChart,
            JFreeChart sumWindspeedMonthChart,
            JFreeChart sumWindspeedQuarterChart,
            JFreeChart avgWindspeedChart,
            JFreeChart histogramChart) 
    {
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
        sumWindspeedQuarter.setBounds(0, chartHeight * 2, chartWidth, chartHeight);
        histogram.setBounds(chartWidth, chartHeight * 2, chartWidth, chartHeight);
        
        chartViewer.removeAll();
        chartViewer.add(polarChart);
        chartViewer.add(avgWindspeed);
        chartViewer.add(histogram);
        chartViewer.add(sumWindspeedQuarter);
        chartViewer.add(sumWindspeedMonth);
        chartViewer.add(sumWindspeedWeek);
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        MainGUI v = new MainGUI();
        
        v.setExtendedState(v.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        
        Data data = null;
        try {
            data = new Data("/home/loki/Documents/Dropbox/Prove IT/107 - Simulatie Windderivaten/test_data_wind.txt");
            data.fill();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Formulas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Formulas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        ChartDataset obj = new ChartDataset(data);
        obj.setInterval(1991, 1992);
        
        v.initGraphs(
                obj.getPolarData(),
                obj.getSumWindspeedWeek(),
                obj.getSumWindspeedMonth(),
                obj.getSumWindspeedQuarter(),
                obj.getAvgWindspeedHourMonth(),
                obj.getWindspeed()
        );
        
        v.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chartViewer;
    // End of variables declaration//GEN-END:variables
}
