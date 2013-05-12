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
    public double scaleX, scaleY;
    
    /**
     * 
     * @param absSize
     * @return Percentage * absSize
     */
    public double absX(double absSize) {
        return scaleX*absSize/100;
    }
    
    /**
     * 
     * @param absSize
     * @return Percentage * absSize
     */
    public double absY(double absSize) {
        return scaleY*absSize/100;
    }
}
