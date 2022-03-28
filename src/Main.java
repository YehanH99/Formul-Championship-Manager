import java.text.ParseException;
public class Main {
    public static void main(String[] args) throws ParseException {
        Formula1ChampionshipManager f1 = new Formula1ChampionshipManager(); //object created
        f1.loadData(); //loading data method called (driver details)
        f1.loadDataByRace(); //loading data method called (race details)
        while (true) {
            f1.menu(); //menu message
        }
    }
}
