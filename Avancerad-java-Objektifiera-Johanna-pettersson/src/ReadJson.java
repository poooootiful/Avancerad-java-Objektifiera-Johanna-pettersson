import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ReadJson{

    ReadJson () {
        System.out.println("Json");

        JFileChooser fileChooser = new JFileChooser("src");
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Json file (.Json)","Json"));
        int option = fileChooser.showOpenDialog(null);

        switch (option) {
            case JFileChooser.APPROVE_OPTION:
                System.out.println("Open");
                //Get the file and send it into the reader
                File file = fileChooser.getSelectedFile();
                Vector<Vector<String>> data = JsonReader(file);
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
    private Vector<Vector<String>> JsonReader(File file) {
        //The Data
        Vector<Vector<String>> data = new Vector<>();

        //Reader and seperating the file
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            JSONTokener token = new JSONTokener(br);
            JSONArray array = new JSONArray (token);

            if (array.length()>0) {
                JSONObject firstline = array.getJSONObject(0);
                Vector<String> colums = new Vector<>(firstline.keySet());
            }

            for (int i = 0; i<array.length(); i++) {
                JSONObject lines = array.getJSONObject(i);
                Vector<String> row = new Vector<>();
                for (String key:lines.keySet()){
                    row.add(lines.getString(key));
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
        JFrame csv = new JFrame("Json Table");
        csv.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        csv.add(sc);
        csv.pack();
        csv.setSize(200,200);
        csv.setVisible(true);
    }

}
