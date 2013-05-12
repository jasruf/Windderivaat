/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author loki
 */
public class Scale {
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
        return PercentageX*absSize/100;
    }
    
    /**
     * 
     * @param absSize
     * @return Percentage * absSize
     */
    public double absY(double absSize) {
        return PercentageY*absSize/100;
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
