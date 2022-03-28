import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class Races {
    public Races() {
        JTable table = new JTable();
        Object[] columns = {"Race Number", "Race Date"}; //names of 2 columns
        DefaultTableModel model = new DefaultTableModel();

        JFrame frame = new JFrame("                                                          " +
                "                      Races"); //edits the frame
        frame.getContentPane().setBackground(new Color(78, 218, 236, 255));
        frame.getContentPane().setForeground(Color.white);
        frame.setBounds(100, 100, 700, 600);

        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        model.setColumnIdentifiers(columns);
        table.setModel(model);

        table.setBackground(Color.white);  //edits everything on the table
        table.setForeground(Color.black); //text color
        table.setSelectionBackground(Color.black); //bg color
        table.setGridColor(Color.magenta);
        table.setSelectionForeground(Color.red);
        table.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        JScrollPane pane = new JScrollPane(table);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.WHITE);
        pane.setBounds(0, 0, 700, 500);
        frame.getContentPane().add(pane);

        Object[] row = new Object[2]; //for 2 columns

        int x = 1;
        Formula1ChampionshipManager f1Manager = new Formula1ChampionshipManager(); //create object by Formula1ChampionshipManager
        for (Race d: f1Manager.races) { //going through each race in races
            row[0] = x; //race number
            row[1] = d.getDate(); // getting date
            x++;
            model.addRow(row); //add row
        }
        frame.setVisible(true);
    }
}