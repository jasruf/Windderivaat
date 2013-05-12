package main;

import java.awt.BorderLayout;
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
 * GUI initialised at startup.
 * @author JASEEN, Loki
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    public GUI() {
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

        polarPanel = new javax.swing.JPanel();
        avgWindSpeedPanel = new javax.swing.JPanel();
        sumWindSpeedQuarterPanel = new javax.swing.JPanel();
        sumWindSpeedMonthPanel = new javax.swing.JPanel();
        sumWindspeedWeekPanel = new javax.swing.JPanel();
        histogramPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 750));
        getContentPane().setLayout(null);

        javax.swing.GroupLayout polarPanelLayout = new javax.swing.GroupLayout(polarPanel);
        polarPanel.setLayout(polarPanelLayout);
        polarPanelLayout.setHorizontalGroup(
            polarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        polarPanelLayout.setVerticalGroup(
            polarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        getContentPane().add(polarPanel);
        polarPanel.setBounds(910, 740, 360, 260);

        javax.swing.GroupLayout avgWindSpeedPanelLayout = new javax.swing.GroupLayout(avgWindSpeedPanel);
        avgWindSpeedPanel.setLayout(avgWindSpeedPanelLayout);
        avgWindSpeedPanelLayout.setHorizontalGroup(
            avgWindSpeedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        avgWindSpeedPanelLayout.setVerticalGroup(
            avgWindSpeedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        getContentPane().add(avgWindSpeedPanel);
        avgWindSpeedPanel.setBounds(1280, 190, 350, 260);

        javax.swing.GroupLayout sumWindSpeedQuarterPanelLayout = new javax.swing.GroupLayout(sumWindSpeedQuarterPanel);
        sumWindSpeedQuarterPanel.setLayout(sumWindSpeedQuarterPanelLayout);
        sumWindSpeedQuarterPanelLayout.setHorizontalGroup(
            sumWindSpeedQuarterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        sumWindSpeedQuarterPanelLayout.setVerticalGroup(
            sumWindSpeedQuarterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        getContentPane().add(sumWindSpeedQuarterPanel);
        sumWindSpeedQuarterPanel.setBounds(1280, 740, 350, 260);

        javax.swing.GroupLayout sumWindSpeedMonthPanelLayout = new javax.swing.GroupLayout(sumWindSpeedMonthPanel);
        sumWindSpeedMonthPanel.setLayout(sumWindSpeedMonthPanelLayout);
        sumWindSpeedMonthPanelLayout.setHorizontalGroup(
            sumWindSpeedMonthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        sumWindSpeedMonthPanelLayout.setVerticalGroup(
            sumWindSpeedMonthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        getContentPane().add(sumWindSpeedMonthPanel);
        sumWindSpeedMonthPanel.setBounds(920, 190, 340, 260);

        javax.swing.GroupLayout sumWindspeedWeekPanelLayout = new javax.swing.GroupLayout(sumWindspeedWeekPanel);
        sumWindspeedWeekPanel.setLayout(sumWindspeedWeekPanelLayout);
        sumWindspeedWeekPanelLayout.setHorizontalGroup(
            sumWindspeedWeekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        sumWindspeedWeekPanelLayout.setVerticalGroup(
            sumWindspeedWeekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );

        getContentPane().add(sumWindspeedWeekPanel);
        sumWindspeedWeekPanel.setBounds(910, 460, 350, 270);

        javax.swing.GroupLayout histogramPanelLayout = new javax.swing.GroupLayout(histogramPanel);
        histogramPanel.setLayout(histogramPanelLayout);
        histogramPanelLayout.setHorizontalGroup(
            histogramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        histogramPanelLayout.setVerticalGroup(
            histogramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        getContentPane().add(histogramPanel);
        histogramPanel.setBounds(1270, 470, 360, 260);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/GUI Base.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1735, 1050);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * @param args the command line arguments
     */
    final int chartWidth = 340;
    final int chartHeight = 260;
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
        
 
        setupCharts();
                
        polarPanel.removeAll();
        avgWindSpeedPanel.removeAll();
        histogramPanel.removeAll();  
        sumWindSpeedQuarterPanel.removeAll();
        sumWindSpeedMonthPanel.removeAll();
        sumWindspeedWeekPanel.removeAll();
                
                
        polarPanel.add(polarChart);
        avgWindSpeedPanel.add(avgWindspeed);
        histogramPanel.add(histogram);
        sumWindSpeedQuarterPanel.add(sumWindspeedQuarter);
        sumWindSpeedMonthPanel.add(sumWindspeedMonth);
        sumWindspeedWeekPanel.add(sumWindspeedWeek);
        
    }
    
    /**
     * Initial setup of charts.
     */
    private void setupCharts() {        
        sumWindspeedWeek.setBounds(0, 0, chartWidth, chartHeight);
        polarChart.setBounds(0, 0, chartWidth, chartHeight);
        sumWindspeedMonth.setBounds(0, 0, chartWidth, chartHeight);
        avgWindspeed.setBounds(0, 0, chartWidth, chartHeight);
        sumWindspeedQuarter.setBounds(0, 0, chartWidth, chartHeight);
        histogram.setBounds(0, 0, chartWidth, chartHeight);
        
        sumWindspeedWeek.setDomainZoomable(false);
        sumWindspeedWeek.setRangeZoomable(false);
        
        sumWindspeedMonth.setDomainZoomable(false);
        sumWindspeedMonth.setRangeZoomable(false);
        
        sumWindspeedQuarter.setDomainZoomable(false);
        sumWindspeedQuarter.setRangeZoomable(false);
        
        avgWindspeed.setDomainZoomable(false);
        avgWindspeed.setRangeZoomable(false);
        
        histogram.setDomainZoomable(false);
        histogram.setRangeZoomable(false);
        
        polarChart.setDomainZoomable(false);
        polarChart.setRangeZoomable(false);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel avgWindSpeedPanel;
    private javax.swing.JPanel histogramPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel polarPanel;
    private javax.swing.JPanel sumWindSpeedMonthPanel;
    private javax.swing.JPanel sumWindSpeedQuarterPanel;
    private javax.swing.JPanel sumWindspeedWeekPanel;
    // End of variables declaration//GEN-END:variables
}