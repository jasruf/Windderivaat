/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chart;

import java.util.List;
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
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tony
 */
public class parseData {
    public static void main(String[] args) {
        try {
            getData();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(parseData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(parseData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void getData() throws FileNotFoundException, IOException {
        final int skipLines = 22;
        int countComma = 0;
        List<Calendar> dateArray = new ArrayList<Calendar>();
        List<Integer> windSpeedArray = new ArrayList<Integer>();
        String data = null;
        String fileName = "/Users/Tony/Dropbox/Prove IT/107 - Simulatie Windderivaten/test_data_wind.txt";
        Calendar date;
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        DataInputStream dis = new DataInputStream(fis);
        BufferedReader br = new BufferedReader(new InputStreamReader(dis));
        if (!file.exists()) {
            System.out.println("I can't find the file: " + fileName);
        }

        for (int i = 0; i < skipLines; i++) {
            br.readLine();
        }
        while (((data = br.readLine()) != null)) {
            date = new GregorianCalendar(Integer.parseInt(data.substring(0, 4)), (Integer.parseInt(data.substring(4, 6)) - 1), Integer.parseInt(data.substring(6, 8)), Integer.parseInt(data.substring(9, 11)), 0);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH");
            dateArray.add(date);
            windSpeedArray.add(Integer.parseInt(data.substring(20, 23).replaceAll("\\s", "")));
            System.out.println(dateFormat.format((dateArray.get(dateArray.size()-1)).getTime())+ " " + windSpeedArray.get(windSpeedArray.size()-1));
            //System.out.println(dateFormat.format(date.getTime()));
        }
        br.close();
        dis.close();
        fis.close();
        

    }
}
