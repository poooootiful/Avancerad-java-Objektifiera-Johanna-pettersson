import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;



import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Vector;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;


public class ReadCsv  {
    JFrame Csv;
    JPanel panel;
    JTable table;
    JScrollPane scrollPane;

    ReadCsv () {

        Csv = new JFrame("Csv");


        System.out.println("Csv");
        JFileChooser fileChooser = new JFileChooser("src");
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter ("csv file (.csv)","csv"));
        int i = fileChooser.showOpenDialog(null);

        if (i==JFileChooser.APPROVE_OPTION) {
            System.out.println("Open");

            File file = fileChooser.getSelectedFile();
            String filepath = file.getPath();
            //String fi = file.getName();
            System.out.println(filepath);
            DefaultTableModel csv_data = new DefaultTableModel();

            try{
                int start = 0;
                InputStreamReader reader = new InputStreamReader(new FileInputStream(filepath));
                org.apache.commons.csv.CSVParser csvParser = CSVFormat.DEFAULT.parse(reader);
            }
        }





            //case JFileChooser.CANCEL_OPTION -> System.out.println("Cancel");
            //case JFileChooser.ERROR_OPTION -> System.out.println("Error");



    }
}