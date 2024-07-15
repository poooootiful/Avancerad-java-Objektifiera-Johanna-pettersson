
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ReadJson extends Gui{

    ReadJson () {
        System.out.println("Json");
        JFileChooser fileChooser = new JFileChooser("src");
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Json file (.Json)","Json"));
        int option = fileChooser.showOpenDialog(null);

        switch (option) {
            case JFileChooser.APPROVE_OPTION -> System.out.println("Open");
            case JFileChooser.CANCEL_OPTION -> System.out.println("Cancel");
            case JFileChooser.ERROR_OPTION -> System.out.println("Error");
        }



    }

}
