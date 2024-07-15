import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ReadCsv {


    ReadCsv() {

        System.out.println("Csv");
        JFileChooser fileChooser = new JFileChooser("src");
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("CSV file (.csv)", "csv"));
        int option = fileChooser.showOpenDialog(null);

        switch (option) {
            case JFileChooser.APPROVE_OPTION:
                System.out.println("Open");
                //Get the file and send it into the reader
                File file = fileChooser.getSelectedFile();
                Vector<Vector<String>> data = CsvReader(file);
                if (data != null) {
                    display(data);
                }
                break;
            case JFileChooser.CANCEL_OPTION:
                System.out.println("Cancel");
                break;
            case JFileChooser.ERROR_OPTION:
                System.out.println("Error");
                break;
        }
    }

    private Vector<Vector<String>> CsvReader(File file) {
        //The Data
        Vector<Vector<String>> data = new Vector<>();

        //Reader and seperating the file
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String [] splits = line.split(",");
                Vector<String> row = new Vector<>();
                for (String split : splits) {
                    row.add(split);
                }
                data.add(row);
            }
        } catch (IOException e) {
            System.err.println("There was a error with message: " + e.getMessage());
        }return data;
    }
    private void display (Vector<Vector<String>> data) {
        //Make the collums
        Vector<String> collums = data.get(0);
        data.remove(0);

        //Make, populate and display the Jtable
        DefaultTableModel tb = new DefaultTableModel(data,collums);
        JTable table = new JTable(tb);
        table.setAutoCreateRowSorter(true);
        JScrollPane sc = new JScrollPane(table);
        JFrame csv = new JFrame("Csv Table");
        csv.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        csv.add(sc);
        csv.pack();
        csv.setSize(200,200);
        csv.setVisible(true);
    }
}