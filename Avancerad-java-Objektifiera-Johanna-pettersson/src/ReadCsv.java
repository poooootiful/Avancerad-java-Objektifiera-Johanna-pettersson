import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class ReadCsv extends Gui {

    JFrame frame = new JFrame("csv");
    JTable table;

    ReadCsv () throws IOException {

        System.out.println("Csv");
        /*JFileChooser fileChooser = new JFileChooser("src");
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter ("csv file (.csv)","csv"));
        int option = fileChooser.showOpenDialog(null);

        switch (option) {
            case JFileChooser.APPROVE_OPTION -> System.out.println("Open");
            case JFileChooser.CANCEL_OPTION -> System.out.println("Cancel");
            case JFileChooser.ERROR_OPTION -> System.out.println("Error");
        }*/

        String file = "src\\Sample.csv";
        BufferedReader reader= null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine())!= null) {

                String [] row = line.split(",");

                for (String index : row) {
                    System.out.printf("%-10s", index);
                }

                System.out.println();
            }

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