import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class SearchDriver {
    public SearchDriver() {
        JTable table = new JTable();
        Object[] columns = {"Race", "Position"};
        DefaultTableModel model = new DefaultTableModel();

        JFrame frame = new JFrame("                                                          " +
                "                      Search Driver"); //edits the frame
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

        Object[] row = new Object[2];//for 2 columns

        JTextField textField = new JTextField(); //create text field
        textField.setBounds(150,510,120,35);
        frame.getContentPane().add(textField);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(15,510,120,35);
        btnSearch.setBackground(new Color(152,174,212));
        frame.getContentPane().add(btnSearch);
        btnSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText(); //getting text in text field

                model.setRowCount(0); //setting row count to 0 at the start

                for (Race d: Formula1ChampionshipManager.races) { //going through each race
                    for (int i = 0; i < d.getPositions().length; i++) { //going through each position of a race
                        if(d.getPositions()[i].getName().equals(text)){ //if drivers name equal to input name
                            row[0] = d.getDate();  //get race date
                            row[1] = i+1; //position
                            model.addRow(row); //adding a row
                        }
                    }
                }
            }
        });
        frame.setVisible(true); //setting visible
    }
}