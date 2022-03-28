import java.text.ParseException;

public interface ChampionshipManager {
    public void createNewDriver(); //all methods are public which used in Formula1ChampionshipManager
    public void deleteDriver();
    public void changeDriver();
    public void statisticsOfADriver();
    public void addRace() throws ParseException;
    public void table();
    public void saveToFile();
    public void loadData();

}
