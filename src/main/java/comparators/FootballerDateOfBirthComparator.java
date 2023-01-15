package comparators;


import lab1.footballclub.*;

import java.util.Comparator;

public class FootballerDateOfBirthComparator implements Comparator<Footballer> {
    @Override
    public int compare(Footballer f1, Footballer f2){
        return f1.getDateOfBirth().compareTo(f2.getDateOfBirth());
    }
}
