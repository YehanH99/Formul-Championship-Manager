import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Collections;

public class GUI_2 {
    public  GUI_2(){
        Formula1ChampionshipManager d1 = new Formula1ChampionshipManager();
        PointCompare p = new PointCompare();
        Collections.sort(d1.drivers, p);
        JTable table = new JTable();
        Object[] columns = {"Name", "Location", "Team", "No.Of Races", "Points", "1st Positions", "2nd Positions", "3rd Positions"};
        DefaultTableModel model = new DefaultTableModel();

        JFrame frame = new JFrame("STATISTICS");
        frame.getContentPane().setBackground(new Color(134, 236, 78, 255));
        frame.getContentPane().setForeground(Color.white);
        frame.setBounds(100, 100,700,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end the program when window is closed
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        model.setColumnIdentifiers(columns);
        table.setModel(model);

        table.setBackground(Color.white);
        table.setForeground(Color.black); //text color
        table.setSelectionBackground(Color.red); //bg color
        table.setGridColor(Color.red);
        table.setSelectionForeground(Color.white);
        table.setFont(new Font("Tahoma", Font.PLAIN,17));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        JScrollPane pane = new JScrollPane(table);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.WHITE);
        pane.setBounds(0,0,700,500);
        frame.getContentPane().add(pane);

        Object[] column = new Object[8]; //for 8 columns

        for (Formula1Driver d: Formula1ChampionshipManager.drivers) { //going through each driver in races
            column[0] = d.getName();
            column[1] = d.getTeamName();  //all the getters
            column[2] = d.getLocation();
            column[3] = d.getNumberOfRaces();
            column[4] = d.getNumberOfPoints();
            column[5] = d.getFirstPositions();
            column[6] = d.getSecondPositions();
            column[7] = d.getThirdPositions();

            model.addRow(column); //adding a row
        }
        frame.setVisible(true);
    }
}

