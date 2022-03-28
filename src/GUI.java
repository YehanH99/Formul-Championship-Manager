import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Collections;

public class GUI {
    public  GUI(){
        JTable table = new JTable();
        Object[] columns = {"Name", "Location", "Team", "No.Of Races", "Points", "First", "Second", "Third"}; //column names
        DefaultTableModel model = new DefaultTableModel(); //table object

        JFrame frame = new JFrame("                                                          " +
                "                      DRIVER STATISTICS TABLE"); //edits the frame
        frame.getContentPane().setBackground(new Color(78, 218, 236, 255));
        frame.getContentPane().setForeground(Color.white);
        frame.setBounds(100, 100,700,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end the program when window is closed
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        model.setColumnIdentifiers(columns);
        table.setModel(model);

        table.setBackground(Color.white);  //edits everything on the table
        table.setForeground(Color.black); //text color
        table.setSelectionBackground(Color.black); //bg color
        table.setGridColor(Color.magenta);
        table.setSelectionForeground(Color.red);
        table.setFont(new Font("Times New Roman", Font.PLAIN,17));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        JScrollPane pane = new JScrollPane(table); //everything about the pane
        pane.setForeground(Color.RED);
        pane.setBackground(Color.WHITE);
        pane.setBounds(0,0,700,500);
        frame.getContentPane().add(pane);

        Object[] column = new Object[8];

        PointCompare pointCompare = new PointCompare();
        Collections.sort(Formula1ChampionshipManager.drivers,pointCompare.reversed());
        for (Formula1Driver d: Formula1ChampionshipManager.drivers) {
            column[0] = d.getName();
            column[1] = d.getTeamName();
            column[2] = d.getLocation();
            column[3] = d.getNumberOfRaces();
            column[4] = d.getNumberOfPoints();
            column[5] = d.getFirstPositions();
            column[6] = d.getSecondPositions();
            column[7] = d.getThirdPositions();

            model.addRow(column);
        }

        JButton btnAscendingOrder = new JButton("Ascending"); //button for ascending order
        btnAscendingOrder.setBounds(15,510,120,35); //button position and dimensions
        btnAscendingOrder.setBackground(new Color(152,174,212));
        frame.getContentPane().add(btnAscendingOrder);
        btnAscendingOrder.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                PointCompare pointCompare = new PointCompare();
                Collections.sort(Formula1ChampionshipManager.drivers,pointCompare);
                for (Formula1Driver d: Formula1ChampionshipManager.drivers) {  //for each driver in drivers array list
                    column[0] = d.getName();
                    column[1] = d.getTeamName();    //all the getters
                    column[2] = d.getLocation();
                    column[3] = d.getNumberOfRaces();
                    column[4] = d.getNumberOfPoints();
                    column[5] = d.getFirstPositions();
                    column[6] = d.getSecondPositions();
                    column[7] = d.getThirdPositions();

                    model.addRow(column);
                }
            }
        });


        JButton btnByFirstPositions = new JButton("By First Places"); //button for first positions sort
        btnByFirstPositions.setBounds(150,510,120,35); //button position and dimensions
        btnByFirstPositions.setBackground(new Color(152,174,212));
        frame.getContentPane().add(btnByFirstPositions);
        btnByFirstPositions.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                FirstPositionCompare firstCompare = new FirstPositionCompare();
                Collections.sort(Formula1ChampionshipManager.drivers, firstCompare.reversed());
                for (Formula1Driver d: Formula1ChampionshipManager.drivers) {  //for each driver in drivers array list
                    column[0] = d.getName();
                    column[1] = d.getTeamName();
                    column[2] = d.getLocation();
                    column[3] = d.getNumberOfRaces();  //all the getters
                    column[4] = d.getNumberOfPoints();
                    column[5] = d.getFirstPositions();
                    column[6] = d.getSecondPositions();
                    column[7] = d.getThirdPositions();

                    model.addRow(column);
                }
            }
        });

        JButton btnRaces = new JButton("Races");  //button for races
        btnRaces.setBounds(285,510,120,35); //button position and dimensions
        btnRaces.setBackground(new Color(152,174,212));
        frame.getContentPane().add(btnRaces);
        btnRaces.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Races race = new Races();
            }
        });

        JButton btnSearch = new JButton("Search");  //button to search drivers races with position and date
        btnSearch.setBounds(420,510,120,35); //button position and dimensions
        btnSearch.setBackground(new Color(152,174,212));
        frame.getContentPane().add(btnSearch);
        btnSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SearchDriver searchDriver = new SearchDriver(); //create object by SearchDriver class
            }
        });

        JButton btnR1 = new JButton("R1");  //button for random race 1
        btnR1.setBounds(550,510,50,35); //button position and dimensions
        btnR1.setBackground(new Color(152,174,212));
        frame.getContentPane().add(btnR1);
        btnR1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    R1 randomRace_1 = new R1(); //create object from R1
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton btnR2 = new JButton("R2");  //button for random race 2 (based on starting position percentage)
        btnR2.setBounds(605,510,50,35); //button position and dimensions
        btnR2.setBackground(new Color(152,174,212));
        frame.getContentPane().add(btnR2);  //adding button to the frame
        btnR2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    R2 randomRace_2  = new R2(); //R2 GUI is opened by creating an object
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        });
        frame.setVisible(true); // setting visible
    }
}

