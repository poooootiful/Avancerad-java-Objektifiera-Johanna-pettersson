import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadCsv extends Gui{

    JTable table = new JTable();

    int Colums =0;
    int Rows =0;

    Scanner Read;

    ReadCsv () {

        System.out.println("Csv");
        JFileChooser fileChooser = new JFileChooser("src");
        int option = fileChooser.showOpenDialog(null);

        switch (option) {
            case JFileChooser.APPROVE_OPTION -> System.out.println("Open");
            case JFileChooser.CANCEL_OPTION -> System.out.println("Cancel");
            case JFileChooser.ERROR_OPTION -> System.out.println("Error");
        }

        try {
            String path = fileChooser.getSelectedFile().toString();
            String filetype = path.split(",");
            File file = fileChooser.getSelectedFile();
            String fileDec = fileChooser.getTypeDescription(file);
            Read = new Scanner(file);
            System.out.println(path);
            System.out.println(filetype);
            System.out.println(fileDec);
        }catch (Exception e) {
            System.out.println("No file picked"+" "+e);
        }

        if (Read.hasNextLine()) {
            Colums  = Read.nextLine().split(",").length;
        }

        Read.close();
        System.out.println(Colums);
    }
}
