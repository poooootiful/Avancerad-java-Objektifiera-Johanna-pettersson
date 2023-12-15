import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class ReadCsv extends Gui{

    JTable table = new JTable();

    int Colums =0;
    int Rows =0;

    Scanner Read;

    public static ArrayList<String> aryL = new ArrayList<>();

    ReadCsv () {

        System.out.println("Csv");
        JFileChooser fileChooser = new JFileChooser("src");
        int option = fileChooser.showOpenDialog(null);

        switch (option) {
            case JFileChooser.APPROVE_OPTION -> System.out.println("Open");
            case JFileChooser.CANCEL_OPTION -> System.out.println("Cancel");
            case JFileChooser.ERROR_OPTION -> System.out.println("Error");
        }
        String[][] array2d = new String[3][11];
        try {
            File file = fileChooser.getSelectedFile();
            Read = new Scanner(file);
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] array = line.split(",");
                aryL.addAll(Arrays.asList(array));
                System.out.println(Arrays.deepToString(array));
                System.out.println(line);
            }
            System.out.println(aryL);
            Read.close();
        } catch (Exception e) {
            System.out.println("ERROR" + e.toString());
        }

    }
}
