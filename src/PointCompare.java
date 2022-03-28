import java.util.Comparator;

public class PointCompare implements Comparator<Formula1Driver>{

    @Override
    public int compare(Formula1Driver driver_1, Formula1Driver driver_2) {
        if(driver_1.getNumberOfPoints() == driver_2.getNumberOfPoints()){ //if no.of points are equal next if is called
            if(driver_1.getFirstPositions() > driver_2.getFirstPositions()){ //if no.of first driver_1 first positions > no.of first driver_2 first positions
                return 1;  //return 1
            }else if(driver_1.getFirstPositions() == driver_2.getFirstPositions()){ //if no.of first driver_1 first positions = no.of first driver_2 first positions
                return 0; //return 1
            }else{  //else return -1
                return -1;
            }
        }else if(driver_1.getNumberOfPoints()> driver_2.getNumberOfPoints()){ //if no.of points by driver_1 first positions > no.of points by first driver_2
            return 1;  //return 1
        }else{  //else return -1
            return -1;
        }
    }
}