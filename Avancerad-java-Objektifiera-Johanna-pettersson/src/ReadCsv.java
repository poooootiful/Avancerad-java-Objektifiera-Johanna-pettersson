import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.io.FileReader;
import java.util.Scanner;

public class ReadCsv extends Gui {

    JFrame frame;
    JTable table;
    String [][] data = {};


    ReadCsv () throws IOException {

        System.out.println("Csv");
        JFileChooser fileChooser = new JFileChooser("src");
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter ("csv file (.csv)","csv"));
        int option = fileChooser.showOpenDialog(null);

        switch (option) {
            case JFileChooser.APPROVE_OPTION -> System.out.println("Open");
            case JFileChooser.CANCEL_OPTION -> System.out.println("Cancel");
            case JFileChooser.ERROR_OPTION -> System.out.println("Error");
        }

        String file = fileChooser.getSelectedFile().toString();
        BufferedReader reader = null;
        String line =  "";
        String [] row;
        
        try {
            reader = new BufferedReader(new FileReader(file));
            
            while ((line=reader.readLine())!=null) {
                row = line.split(",");
                for (String index : row) {
                    System.out.printf("%-10s", index);
                }
                System.out.println();
            }

            String [] columnNames = {"OrderDate", "Region", "Rep1", "Rep2", "Item", "Units", "UnitCost", "Total"};

            frame = new JFrame("Csv");

            table = new JTable(data,columnNames);
            table.setBounds(30,40,200,300);

            JScrollPane sp = new JScrollPane();
            frame.add(sp);
            frame.setSize(500,200);
            frame.setVisible(true);

        }catch (Exception e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}