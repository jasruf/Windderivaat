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
    public static void main(String[] args) {
        Data data = new Data("/Users/Tony/Dropbox/Prove IT/107 - Simulatie Windderivaten/test_data_wind.txt");
        try {
            data.fill();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
            
    private final int skipLines;
    private List<Calendar> dateArray = new ArrayList<Calendar>();
    private List<Integer> windSpeedArray = new ArrayList<Integer>();
    private String data;
    private String fileName;
    private File file;
    private FileInputStream fis;
    private DataInputStream dis;
    private BufferedReader br;
    private SimpleDateFormat dateFormat;

    public Data(String filename) {
        skipLines = 22;
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
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH");
    }
    
    public List<Calendar> getDateArray() {
        return dateArray;
    }

    public List<Integer> getWindSpeedArray() {
        return windSpeedArray;
    }

    public void fill() throws FileNotFoundException, IOException {
        Calendar date;
        if (!file.exists()) {
            System.out.println("I can't find the file: " + fileName);
        }

        for (int i = 0; i < skipLines; i++) {
            br.readLine();
        }
        while (((data = br.readLine()) != null)) {
            date = new GregorianCalendar(Integer.parseInt(data.substring(0, 4)), (Integer.parseInt(data.substring(4, 6)) - 1), Integer.parseInt(data.substring(6, 8)), Integer.parseInt(data.substring(9, 11)), 0);

            dateArray.add(date);
            windSpeedArray.add(Integer.parseInt(data.substring(20, 23).replaceAll("\\s", "")));
            //System.out.println(dateFormat.format((dateArray.get(dateArray.size()-1)).getTime())+ " " + windSpeedArray.get(windSpeedArray.size()-1));
            //System.out.println(dateFormat.format(date.getTime()));
        }
        for (int i = 0; i < windSpeedArray.size(); i++) {
            System.out.println(dateFormat.format(dateArray.get(i).getTime()) + " " + windSpeedArray.get(i));
        }
        br.close();
        dis.close();
        fis.close();
    }


    
}
