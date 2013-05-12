/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author loki
 */
public class Scale {
    public static void setBounds(JPanel panel, int percentX, int percentY, int percentWidth, int percentHeight) {
        Scale scalePos = new Scale(percentX, percentY);
        Scale scaleSize = new Scale(percentWidth, percentHeight);
        
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        panel.setBounds(scalePos.absX(width), scalePos.absY(height), scaleSize.absX(width), scaleSize.absY(height));
    }
    
    
    private double PercentageX, PercentageY;
    
    
    Scale(int scaleX, int scaleY) {
        setPercentageX(scaleX);
        setPercentageY(scaleY);
    }
    /**
     * 
     * @param absSize
     * @return Percentage * absSize
     */
    public int absX(int absSize) {
        return (int)(PercentageX*absSize)/100;
    }
    
    /**
     * 
     * @param absSize
     * @return Percentage * absSize
     */
    public int absY(int absSize) {
        return (int)(PercentageY*absSize)/100;
    }

    /**
     * @param scaleX the scaleX to set
     */
    public void setPercentageX(int scaleX) {
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
    public void setPercentageY(int scaleY) {
        if(scaleY < 0) {
            throw new IllegalArgumentException("percentage can't be lower than 0");
        }
        if(scaleY > 100) {
            throw new IllegalArgumentException("percentage can't be higher than 100");
        }
        
        this.PercentageY = scaleY;
    }
}
