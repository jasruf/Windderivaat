/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author loki
 */
public class Scale {
    public static void setBounds(Component panel, double percentX, double percentY, double percentWidth, double percentHeight) {
        Scale scalePos = new Scale(percentX, percentY);
        Scale scaleSize = new Scale(percentWidth, percentHeight);
        
        double width = Toolkit.getDefaultToolkit().getScreenSize().width;
        double height = Toolkit.getDefaultToolkit().getScreenSize().height;

        panel.setBounds((int)scalePos.absX(width), (int)scalePos.absY(height),(int)scaleSize.absX(width), (int)scaleSize.absY(height));
    }
    
    
    private double PercentageX, PercentageY;
    
    
    Scale(double scaleX, double scaleY) {
        setPercentageX(scaleX);
        setPercentageY(scaleY);
    }
    /**
     * 
     * @param absSize
     * @return Percentage * absSize
     */
    public double absX(double absSize) {
        return (PercentageX*absSize)/100;
    }
    
    /**
     * 
     * @param absSize
     * @return Percentage * absSize
     */
    public double absY(double absSize) {
        return (PercentageY*absSize)/100;
    }

    /**
     * @param scaleX the scaleX to set
     */
    public void setPercentageX(double scaleX) {
        if(scaleX < 0) {
            throw new IllegalArgumentException("percentage can't be lower than 0");
        }
        if(scaleX > 100) {
            throw new IllegalArgumentException("percentage can't be higher than 100");
        }
        
        this.PercentageX = scaleX;
    }

    /**
     * @param scaleY the scaleY to set
     */
    public void setPercentageY(double scaleY) {
        if(scaleY < 0) {
            throw new IllegalArgumentException("percentage can't be lower than 0");
        }
        if(scaleY > 100) {
            throw new IllegalArgumentException("percentage can't be higher than 100");
        }
        
        this.PercentageY = scaleY;
    }
}
