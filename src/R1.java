import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class R1 {
    public R1() throws ParseException {
        JTable table = new JTable();
        Object[] columns = {"Player", "Start", "End"};
        DefaultTableModel model = new DefaultTableModel();

        JFrame frame = new JFrame("                                                          " +
                "                      Random Race 1");  //edits the frame
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


        Object[] column = new Object[3]; //for 3 columns
        PointCompare pointCompare = new PointCompare(); //make PointCompare object

        ArrayList<Integer> positionWon = new ArrayList(); //arrayList containing winning positions
        Formula1ChampionshipManager f = new Formula1ChampionshipManager(); //object by Formula1ChampionshipManager
        int x = 1;
        for (Formula1Driver d:f.drivers) { //adding positions to positionWon arrayList
            positionWon.add(x);
            x++;
        }
        Collections.shuffle(positionWon); //shuffle winning positions arraylist

        int i = 1;
        Formula1Driver [] sortedList = new Formula1Driver[f.drivers.size()]; //sorted arrayList for drivers
        Collections.shuffle(Formula1ChampionshipManager.drivers); //shuffle drivers
        for (Formula1Driver d: Formula1ChampionshipManager.drivers) { //adding cells to a column from drivers arrayList??
            column[0] = d.getName();
            column[1] = i;
            column[2] = positionWon.get(i-1);

            sortedList[i-1] = d; // adding driver to the arrayList

            d.setPointsByPosition(i-1); //set points by position of driver
            model.addRow(column);   //adding row to the model
            i++;
        }
        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date()); //get the date
        Race r = new Race(date,sortedList); //create a Race object
        f.races.add(r); //adding race to the races
        f.saveToFile(); //save data to a text file up to that point
        f.saveToFileRaces(); //save race data to a text file up to that point

        frame.setVisible(true); //setting frame visible
    }
}