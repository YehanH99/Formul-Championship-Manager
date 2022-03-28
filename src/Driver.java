import java.io.Serializable;

public abstract class Driver implements Serializable {
    private String name;    //driver name (private)
    private String location; //driver location (private)
    private String teamName; //driver team name (private)

    public String getName() { //getter for driver name
        return name;
    }

    public String getLocation() { //getter for driver's location
        return location;
    }

    public String getTeamName() { //getter for driver's team name
        return teamName;
    }

    public void setName(String name) {  //setter for driver name
        this.name = name;
    }

    public void setLocation(String location) {   //setter for driver location
        this.location = location;
    }

    public void setTeamName(String teamName) {  //setter for driver team name
        this.teamName = teamName;
    }
}
