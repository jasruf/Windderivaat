/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import chart.Data;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import math.ChartDataset;
import math.Formulas;

/**
 *
 * @author loki
 */
public class Main {
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        GUI gui = new GUI();
        gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
        gui.resize(Toolkit.getDefaultToolkit().getScreenSize());
        
        
        
        Data data = null;
        try {
            data = new Data("test_data_wind.txt");
            data.fill();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Formulas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Formulas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        ChartDataset obj = new ChartDataset(data);
        obj.setInterval(1991, 1992);
        
        gui.initGraphs(
                obj.getPolarData(),
                obj.getSumWindspeedWeek(),
                obj.getSumWindspeedMonth(),
                obj.getSumWindspeedQuarter(),
                obj.getAvgWindspeedHourMonth(),
                obj.getWindspeed()
        
                );
        
        gui.setVisible(true);
    }
}
