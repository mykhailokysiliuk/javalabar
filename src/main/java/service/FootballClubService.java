package service;

import comparators.FootballerComparator;
import comparators.FootballerDateOfBirthComparator;
import lab1.footballclub.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FootballClubService {
    private FootballClub footballClub;

    public FootballClubService(FootballClub fc) {
        footballClub = fc;
    }

    public List<Footballer> sortByFirstnameLastname() {
        List<Footballer> footballers = new ArrayList<>();
        footballers.addAll(footballClub.getFootballers());
        Collections.sort(footballers);
        footballers.sort(new FootballerComparator());
        return footballers;
    }

    public List<Footballer> sortByFirstnameLastnameStream() {
        return footballClub.getFootballers().stream().sorted(new FootballerComparator()).collect(Collectors.toList());
    }

    public List<Footballer>sortByDateOfBirth(){
        List<Footballer> footballers = new ArrayList<>();
        footballers.addAll(footballClub.getFootballers());
        Collections.sort(footballers);
        footballers.sort(new FootballerDateOfBirthComparator());
        return footballers;
    }

    public List<Footballer> sortByDateOfBirthStream(){
        return footballClub.getFootballers().stream().sorted(new FootballerDateOfBirthComparator()).collect(Collectors.toList());
    }

    public List<Footballer> findByName(String name){
        List<Footballer> footballers = new ArrayList<>();
        for (Footballer footballer : footballClub.getFootballers()) {
            if (footballer.getFirstname() == name) {
                footballers.add(footballer);
            }
        }
        return footballers;
    }
    public List<Footballer> findByNameStream(String name){
        return footballClub.getFootballers().stream().filter(firstname -> firstname.getFirstname().contains(name)).collect(Collectors.toList());
    }

    public List<Footballer> filterGoalsNumber(int number){
        List<Footballer> footballers = new ArrayList<>();
        for (Footballer footballer : footballClub.getFootballers()) {
            if (footballer.getGoalsNumber() > number) {
                footballers.add(footballer);
            }
        }
        return footballers;
    }
    public List<Footballer> filterGoalsNumberStream(int number){
        return footballClub.getFootballers().stream().filter(goalsNumber -> goalsNumber.getGoalsNumber() > number).collect(Collectors.toList());
    }
}