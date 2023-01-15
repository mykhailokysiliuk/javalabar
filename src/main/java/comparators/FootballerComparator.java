package comparators;

import lab1.footballclub.*;

import java.util.Comparator;

public class FootballerComparator implements Comparator<Footballer> {
    @Override
    public int compare(Footballer f1, Footballer f2){
        if (f1.getFirstname().compareTo(f2.getFirstname()) == 0) {
            return f1.getLastname().compareTo(f2.getLastname());
        }
        return f1.getFirstname().compareTo(f2.getFirstname());
    }
}
