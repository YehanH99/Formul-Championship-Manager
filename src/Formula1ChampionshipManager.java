import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Formula1ChampionshipManager implements ChampionshipManager {  //implementation using ChampionshipManager
    public static ArrayList<Formula1Driver> drivers = new ArrayList<Formula1Driver>(); // arraylist storing driver objects
    static ArrayList<Race> races = new ArrayList<Race>(); // arraylist storing race details

    public void menu() throws ParseException { //displaying menu
        System.out.println("\n----------------Main Menu----------------\n");
        System.out.println("1 - Create new driver \n2 - Delete driver \n3 - Change Driver \n4 - Statistics of an existing driver\n" +
        "5 - Display table \n6 - Add a race \n7 - Work with GUI");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter option: ");
        String option = input.nextLine(); //taking user input option
        if (option.equals("1")) {
            createNewDriver(); //calling createNewDriver method
        } else if (option.equals("2")) {
            deleteDriver(); //calling deleteDriver method
        } else if (option.equals("3")) {
            changeDriver(); //calling changeDriver method method
        } else if (option.equals("4")) {
            statisticsOfADriver(); //calling statisticsOfADriver method
        } else if (option.equals("5")) {
            table(); //calling displayPointsTable method
        } else if (option.equals("6")) {
            addRace(); //calling addRace method
        } else if (option.equals("7")){
            GUI gui = new GUI(); //starting GUI with the creation of object
        }else{
            System.out.println("Invalid option entered..."); //alerting user when input is wrong
        }
    }

    public void createNewDriver() { //Create new driver method
        System.out.println("-------------Create New Driver-------------");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter driver name: ");
        String driverName = input.nextLine(); //taking driver name as input
        if(uniqueDriverNameCheck(driverName)){ //calling uniqueDriverNameCheck method by giving name as parameter
            System.out.print("Enter driver team: ");
            String driverTeam = input.nextLine(); //taking driver team as input

            if(uniqueTeamCheck(driverTeam)) { //calling uniqueTeamCheck method by giving name as parameter
                System.out.print("Enter driver location: ");
                String driverLocation = input.nextLine(); //take user input for location
                Formula1Driver driver = new Formula1Driver(); //creating object from Formula1Driver
                driver.setName(driverName); //set name to new object
                driver.setLocation(driverLocation); //set location to new object
                driver.setTeamName(driverTeam); //set team name to new object
                drivers.add(driver); //adding created object to drivers arraylist
            }else{
                System.out.println("This team is already added..."); //alert if the team is already registered
            }
        }else{
            System.out.println("This driver is already added...");//alert if the driver name is already registered
        }
        saveToFile(); //save data to a text file up to that point
    }
    public boolean uniqueDriverNameCheck(String driverName){ //method use to check unique driver
        for(Formula1Driver driver: drivers){ //going through each object in drivers arraylist
            if(driverName.equals(driver.getName())){ //check whether driverName.equals(driver.getName())
                return false; //return false if driver is already registered
            }
        }
        return true; //return true if driver not registered
    }
    public boolean uniqueTeamCheck(String driverTeam){ //method use to check unique team
        for (Formula1Driver driver: drivers) { //going through each object in drivers arraylist
            if (driverTeam.equals(driver.getTeamName())){ //check whether driverTeam.equals(driver.getTeamName())
                return false;//return false if team name is already registered
            }
        }
        return true; //return true if driver not registered
    }

    public void deleteDriver() { // Delete driver
        System.out.println("-------------Delete a Driver-------------");
        Scanner input = new Scanner(System.in); //scanner
        System.out.print("Enter driver you want to delete: ");
        String driverName = input.nextLine(); //taking name of driver want to delete
        boolean deleted = false;
        for (Formula1Driver driver : drivers) { //going through each object in drivers arraylist
            if (driverName.equals(driver.getName())) {
                drivers.remove(driver);
                System.out.println("Driver deleted...");
                deleted = true;
                break;
            }
        }
        if(!deleted){  //when there is no such driver
            System.out.println("There is no such driver...");
        }
        saveToFile(); //save data to a text file up to that point
    }

    public void changeDriver() { //Change Driver
        System.out.println("-------------Change Driver for an existing team-------------");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter driver you want to change: ");
        String oldDriver = input.nextLine(); //input driver name to change
        boolean changed = false;
        for (Formula1Driver driver : drivers) {   //going through each object in drivers arraylist
            if (oldDriver.equals(driver.getName())) { //check whether driver is already there
                System.out.print("Enter new driver: ");
                String newDriver = input.nextLine(); //take new driver name as input
                driver.setName(newDriver);  //set new name
                System.out.print("Enter new driver's location: ");
                String newDriverLocation = input.nextLine(); //taking new location from user
                driver.setLocation(newDriverLocation);  //set new location
                changed = true;
                break;
            }
        }
        if(!changed){  //when there is no such driver
            System.out.println("There is no such driver...");
        }
        saveToFile(); //save data to a text file up to that point
    }

    public void statisticsOfADriver() {    //individual driver statistics method
        System.out.println("\n-------------Display Statistics for a Selected Driver-------------\n");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name of driver for statistics: ");
        String driverForStats = input.nextLine(); //taking name of driver want statistics
        boolean stats = false;
        for (Formula1Driver driver : drivers) { //going through each object in drivers arraylist
            if (driverForStats.equals(driver.getName())) { //for loop to print all data of a single driver
                System.out.println("\n-------------Driver details-------------\n");
                System.out.println("Driver's name - " + driver.getName()); //get driver name
                System.out.println("Driver's location - " + driver.getLocation()); //get driver location
                System.out.println("Driver's team - " + driver.getTeamName()); //get driver team name
                System.out.println("Number of races - " + driver.getNumberOfRaces()); //get driver's no.of races
                System.out.println("Number of Points - " + driver.getNumberOfPoints()); //get driver's no.of points
                System.out.println("1st Positions - " + driver.getFirstPositions()); //get driver's no.of first positions
                System.out.println("2nd Positions - " + driver.getSecondPositions()); //get driver's no.of second positions
                System.out.println("3rd Positions - " + driver.getThirdPositions()); //get driver's no.of third positions
                stats = true;
                break; //leaves the loop after 'if' runs for at least one time
            }
        }
        if(!stats){  //when there is no such driver
            System.out.println("There is no such driver...");
        }
    }
    private boolean isValid(String dateStr) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(dateStr);
        }
        catch (ParseException e) {
            return false; //false is returned when invalid
        }
        return true; //true is returned when valid
    }

        public void addRace() throws ParseException { //add race method
        System.out.println("-------------Add Race-------------");
        Scanner input = new Scanner(System.in);
        Formula1Driver[] racePositions = new Formula1Driver[drivers.size()]; //Array to put positions in the race
        System.out.print("Input race date (DD/MM/YYYY): ");

        String raceDate = input.nextLine(); //taking race date as user input
        if (isValid(raceDate)) {
                for (int i = 0; i < racePositions.length; i++) { //for loop for the length of racePositions array
                    System.out.print("Enter driver name for position " + (i + 1) + ": ");
                    String driverByPosition = input.nextLine(); //user input for each position
                    racePositions[i] = findDriver(driverByPosition); //
                    findDriver(driverByPosition).setPointsByPosition(i + 1);
                }
                Race r1 = new Race(raceDate, racePositions);
                races.add(r1);
                saveToFile(); //save data to a text file up to that point
                saveToFileRaces(); //save race data to a text file up to that point
            }
        else{
            System.out.println("Enter correct date format...");
        }
    }

    public Formula1Driver findDriver(String driverByPosition) {
        for (Formula1Driver driver : drivers) {
            if (driverByPosition.equals(driver.getName())) {
                return driver;
            }
        }
        Formula1Driver d = new Formula1Driver();        //error handled
        return d;
    }

    public void table(){

        Collections.sort(drivers,new PointCompare().reversed());
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("|   Driver   |  TeamName  |  Location  |  Races  |  Points  |  First  |  Second  |  Third  |");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (Formula1Driver driver:drivers) {
            System.out.printf("| %10s | %10s | %10s | %7d | %8d | %7d | %8d | %7d |",driver.getName(),driver.getTeamName(),driver.getLocation(),driver.getNumberOfRaces(),driver.getNumberOfPoints(),driver.getFirstPositions(),
                    driver.getSecondPositions(),driver.getThirdPositions());
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------------------------------");
    }


    public void saveToFile() { //method use to save drivers' data into a text file
        File file_save = new File("DriverDetails.txt"); //new object with File reference
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file_save);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(drivers);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadData() { //loading from the text file
        try {
            FileInputStream file_load = new FileInputStream("DriverDetails.txt");//new object with FileInputStream reference
            ObjectInputStream objectInputStream = new ObjectInputStream(file_load);
            drivers = (ArrayList<Formula1Driver>) objectInputStream.readObject();
            objectInputStream.close();
            file_load.close();
        } catch (EOFException ex1) { //display message when error occurred
            System.out.println("Error");

        } catch (IOException | ClassNotFoundException e) { //display message when error occurred
            System.out.println("Error while loading...");
            e.printStackTrace();
        }
    }

    public void saveToFileRaces() { // race data save to text file
        File file_save = new File("saveToFileRaces.txt"); //new object with File reference
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file_save);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(races);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadDataByRace() { // loading race data by text file
        try {
            FileInputStream file_load = new FileInputStream("saveToFileRaces.txt"); //new object with FileInputStream reference
            ObjectInputStream objectInputStream = new ObjectInputStream(file_load); //new object with ObjectInputStream reference
            races = (ArrayList<Race>) objectInputStream.readObject();
            objectInputStream.close();
            file_load.close();
        } catch (EOFException ex1) {
            System.out.println("Error"); //display message when error occurred


        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while loading...");  //display message when error occurred
            e.printStackTrace();
        }
    }
}