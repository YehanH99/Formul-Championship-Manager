import java.util.Comparator;

public class FirstPositionCompare implements Comparator<Formula1Driver>{

    @Override
    public int compare(Formula1Driver driver_1, Formula1Driver driver_2) {
        if(driver_1.getFirstPositions() == driver_2.getFirstPositions()){ //if driver_1 and driver_2 have same
            return 0;                                                // no.of first positions return 0
        }else if(driver_1.getFirstPositions() > driver_2.getFirstPositions()){//if driver_1 have more no.of
            return 1;                                           // first positions than driver_2 return 1
        }else{  //else return -1
            return -1;
        }
    }
}
