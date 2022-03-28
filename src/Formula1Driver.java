import java.io.Serializable;

public class Formula1Driver extends Driver implements Serializable {
    private static final long serialVersionUID = 1001L;
    private int firstPositions;
    private int secondPositions;
    private int thirdPositions;
    private int numberOfPoints;
    private int numberOfRaces;       //points 1:25  2:18  3:15  4:12  5:10  6:8  7:6  8:4  9:2  10:1

    public void setPointsByPosition(int position){  //to increase the no.of points of first 10 positions
        numberOfRaces++;
        if(position == 1){
            numberOfPoints += 25;
            firstPositions += 1;
        }else if(position == 2){
            numberOfPoints += 18;
            secondPositions += 1;
        }else if(position == 3){
            numberOfPoints += 15;
            thirdPositions += 1;
        }else if(position == 4){
            numberOfPoints += 12;
        }else if(position == 5){
            numberOfPoints += 10;
        }else  if(position == 6){
            numberOfPoints += 8;
        }else if(position == 7){
            numberOfPoints += 6;
        }else if(position == 8){
            numberOfPoints += 4;
        }else if(position == 9){
            numberOfPoints += 2;
        }else if(position == 10){
            numberOfPoints +=1;
        }
    }

    public int getFirstPositions() { //getter for no.of first positions
        return firstPositions;
    }
    public int getSecondPositions() { //getter for no.of second positions
        return secondPositions;
    }

    public int getThirdPositions() { //getter for no.of third positions
        return thirdPositions;
    }

    public int getNumberOfPoints() {  //getter for no.of points
        return numberOfPoints;
    }

    public int getNumberOfRaces() { //getter for no.of races
        return numberOfRaces;
    }

    public void setFirstPositions(int first_positions) {  //setter for no.of races
        this.firstPositions = first_positions;
    }

    public void setSecondPositions(int second_positions) { //setter for no.of races
        this.secondPositions = second_positions;
    }

    public void setThirdPositions(int third_positions) { //setter for no.of races
        this.thirdPositions = third_positions;
    }

    public void setNumberOfPoints(int numberOfPoints) { //setter for no.of races
        this.numberOfPoints = numberOfPoints;
    }

    public void setNumberOfRaces(int numberOfRaces) { //setter for no.of races
        this.numberOfRaces = numberOfRaces;
    }
}
