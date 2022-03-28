import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

public class R2 {
    public R2() throws ParseException {
        JTable table = new JTable();
        Object[] columns = {"Player", "Start", "End"};
        DefaultTableModel model = new DefaultTableModel();

        JFrame frame = new JFrame("                                                          " +
                "                      Random Race 2");  //edits the frame
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
        PointCompare pointCompare = new PointCompare();

        ArrayList<Integer> positionsWon = Places();
        Formula1ChampionshipManager f = new Formula1ChampionshipManager();
        int x = 1;
        for (Formula1Driver d:f.drivers) {
            positionsWon.add(x);
            x++;
        }

        int i=1;
        Formula1Driver [] sorted = new Formula1Driver[f.drivers.size()];
        Collections.shuffle(Formula1ChampionshipManager.drivers);
        for (Formula1Driver d: Formula1ChampionshipManager.drivers) {
            column[0] = d.getName();
            column[1] = i;
            column[2] = positionsWon.get(i-1);

            sorted[i-1] = d;

            d.setPointsByPosition(i-1);
            model.addRow(column);
            i++;
        }
        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        Race r = new Race(date,sorted);
        f.races.add(r);
        f.saveToFile(); //save data to a text file up to that point
        f.saveToFileRaces(); //save race data to a text file up to that point

        frame.setVisible(true);
    }
    Boolean checkIn(int i){ //checking percentage
        Boolean In = true;
        Random random = new Random(); //creating random number
        int randomGot = random.nextInt(100) + 1; //in range 1 - 100
        if(i >= randomGot){ //check number within the percentage
            return In; //return true
        }
        In = false; //else return false
        return In;
    }

    ArrayList<Integer> Places(){
        Formula1ChampionshipManager f = new Formula1ChampionshipManager();
        int size = f.drivers.size(); //get the size of drivers ArrayList

        int whoFirst; //to contain who is first
        whoFirst = 0;
        if(checkIn(2)){
            whoFirst = 9;
        }else if(checkIn(2)){
            whoFirst=5;
        }else if(checkIn(10)){
            whoFirst=4;
        }else if(checkIn(10)){
            whoFirst=3;
        }else if(checkIn(30)){
            whoFirst=2;
        }else if(checkIn(2)){
            whoFirst=8;
        }else if(checkIn(2)){
            whoFirst=7;
        }else if(checkIn(2)){
            whoFirst=6;
        }else{
            whoFirst=1;
        }

        ArrayList<Integer> places = new ArrayList<Integer>(); //arrayList containing places
        for (int j = 2; j <size + 1; j++) {
            places.add(j); //adding places to the arrayList
        }
        Collections.shuffle(places); //shuffle places
        places.add(whoFirst - 1,1);  //adding first place to the given index who has first
        return places;
    }
}