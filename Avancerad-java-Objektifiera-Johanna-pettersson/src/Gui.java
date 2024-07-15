import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {
    JFrame frame = new JFrame();
    JPanel ButtonPanel = new JPanel();
    JButton Csv = new JButton("Csv");
    JButton Json = new JButton("Json");


    Gui () {
        //Starting the gui
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        //Add ButtonPanel to frame
        frame.add(ButtonPanel);

        //Add buttons to panel and add ActionListener to buttons
        ButtonPanel.add(Csv);
        Csv.addActionListener(this);
        ButtonPanel.add(Json);
        Json.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();

        //Make buttons execute the Csv/Json Classes
        if (btn.matches("Csv"))  {
            new ReadCsv();
        }
        if (btn.matches("Json")) {
            new ReadJson();
        }
    }
}
