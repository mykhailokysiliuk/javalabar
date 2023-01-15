package service;

import lab1.footballclub.FootballClub;
import lab1.footballclub.Footballer;
import lab1.footballclub.Position;
import lab1.footballclub.Trainer;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Trainer trainer = new Trainer.Builder()
                .setFirstname("Charles")
                .setLastname("Klimt")
                .setCareerBeginning(LocalDate.of(1975, 12, 12)).build();

        Position position = new Position.Builder()
                .setPositionName("attacker")
                .setTrainer(trainer).build();

        Footballer footballer1 = new Footballer.Builder()
                .setFirstname("Cristiano")
                .setLastname("Ronaldo")
                .setDateOfBirth(LocalDate.of(1985, 2, 5))
                .setPhysicalCondition(Footballer.PhysicalCondition.healthy)
                .setGoalsNumber(837)
                .setPosition(position).build();
        Footballer footballer2 = new Footballer.Builder()
                .setFirstname("Lionel")
                .setLastname("Messi")
                .setDateOfBirth(LocalDate.of(1987, 6, 24))
                .setPhysicalCondition(Footballer.PhysicalCondition.healthy)
                .setGoalsNumber(837)
                .setPosition(position).build();
        Footballer footballer3 = new Footballer.Builder()
                .setFirstname("Kylian")
                .setLastname("Mbappe")
                .setDateOfBirth(LocalDate.of(1998, 12, 20))
                .setPhysicalCondition(Footballer.PhysicalCondition.healthy)
                .setGoalsNumber(254)
                .setPosition(position).build();
        Footballer footballer4 = new Footballer.Builder()
                .setFirstname("Antoinne")
                .setLastname("Griezmann")
                .setDateOfBirth(LocalDate.of(1991, 3, 21))
                .setPhysicalCondition(Footballer.PhysicalCondition.healthy)
                .setGoalsNumber(164)
                .setPosition(position).build();

        List<Footballer> footballersList = List.of(footballer1, footballer2, footballer3, footballer4);


        FootballClub footballClub = new FootballClub.Builder()
                .setFootballClubName("Football Club")
                .setFootballers(footballersList).build();

        FootballClubService footballClubService = new FootballClubService(footballClub);

        System.out.println("Footballers sorted by full name:");
        System.out.println(footballClubService.sortByFirstnameLastname());

        System.out.println("\nFootballers sorted by full name (Stream):");
        System.out.println(footballClubService.sortByFirstnameLastnameStream());

        System.out.println("\nFootballers sorted by date of birth: ");
        System.out.println(footballClubService.sortByDateOfBirth());

        System.out.println("\nFootballers sorted by date of birth (Stream): ");
        System.out.println(footballClubService.sortByDateOfBirthStream());

        System.out.println("\nFind Footballer by firstname - Cristiano");
        System.out.println(footballClubService.findByName("Cristiano"));

        System.out.println("\nFind Footballer by firstname - Cristiano (Stream) ");
        System.out.println(footballClubService.findByNameStream("Cristiano"));

        System.out.println("\nFilter footballers by number of goals - more than 500 ");
        System.out.println(footballClubService.filterGoalsNumber(500));

        System.out.println("\nFilter footballers by number of goals - more than 500 (Stream)");
        System.out.println(footballClubService.filterGoalsNumberStream(500));



    }

}
