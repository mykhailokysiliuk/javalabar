package serealization;

import lab1.footballclub.*;

import java.util.List;

public interface Serializer {
    List<Footballer> listFromFile(String filename);

    Footballer fromFile(String fileName);

    void toFile(Footballer footballer, String fileName);

    void listToFile(List<Footballer> Footballer, String fileName);
}

