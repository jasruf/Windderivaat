/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chart;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tony
 */
public class Data {

    
    // This main was added for testing only
//    public static void main(String[] args) { 
//        Data data = new Data("/Users/Tony/Dropbox/Prove IT/107 - Simulatie Windderivaten/test_data_wind.txt");//In the arguments give the path of the data documents 
//        try {
//            data.fill();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    private final int skipLines;// How many line to skip 
    private List<Calendar> dateArray = new ArrayList<Calendar>();// ArrayList for the date 
    private List<Integer> windSpeedArray = new ArrayList<Integer>();//ArrayList for the wind speed 
    private String data;// String is being used to pick up data from the data documents and is use to fill the array 
    private String fileName;// String being used to tell the program where the data documents is
    private File file;//File is the fileName 
    private FileInputStream fis;
    private DataInputStream dis;
    private BufferedReader br;
    private SimpleDateFormat dateFormat;
    
    
    public Data(String filename) {//method used to get data ready for use 
        skipLines = 22;//
        dateArray = new ArrayList<Calendar>();
        windSpeedArray = new ArrayList<Integer>();
        data = null;
        fileName = filename; //"/Users/Tony/Dropbox/Prove IT/107 - Simulatie Windderivaten/test_data_wind.txt"
        file = new File(fileName);
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        dis = new DataInputStream(fis);
        br = new BufferedReader(new InputStreamReader(dis));
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH");//SimpleDateFormat is used to show the date as a specific format
    }

    public List<Calendar> getDateArray() {
        return dateArray;
    }

    public List<Integer> getWindSpeedArray() {
        return windSpeedArray;
    }

    public void fill() throws FileNotFoundException, IOException {
        Calendar date;
        if (!file.exists()) {// Error prompt that the file is not found 
            System.out.println("I can't find the file: " + fileName);
        }

        for (int i = 0; i < skipLines; i++) {
            br.readLine();// Skip the lines that we don't need "lines with no data"
        }
        while (((data = br.readLine()) != null)) {//Whille we can still get data add it to both arraylists "the date and wind speed"
            //Set the date with date valuetype as a GergorinCalender and add the year, month, day, hour and the minutes are set to 0 "0 because we dont have the minutes and dont need them"
            date = new GregorianCalendar(Integer.parseInt(data.substring(0, 4)), (Integer.parseInt(data.substring(4, 6)) - 1), Integer.parseInt(data.substring(6, 8)), Integer.parseInt(data.substring(9, 11)), 0);
            dateArray.add(date);// add the date to the ArrayList and replace 
            windSpeedArray.add(Integer.parseInt(data.substring(20, 23).replaceAll("\\s", "")));//Add the wind speed to the ArrayList and replaces any spaces with nothing
            
            //System.out.println(dateFormat.format(date.getTime()));//Testing output just after filling the first data into the array 
        }
//        for (int i = 0; i < windSpeedArray.size(); i++) {// print after the list has been tottaly filled 
//            System.out.println(dateFormat.format(dateArray.get(i).getTime()) + " " + windSpeedArray.get(i));
//        }
        br.close();
        dis.close();
        fis.close();
    }
}
