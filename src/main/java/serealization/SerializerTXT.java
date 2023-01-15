package serealization;
import lab1.footballclub.*;
import lab1.footballclub.Footballer;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SerializerTXT implements Serializer{
    private String toString(Footballer f) {
        return
                "Firstname~" + f.getFirstname() + "~" +
                        "Lastname~" + f.getLastname() + "~" +
                        "Date of birth~" + f.getDateOfBirth() + "~" +
                        "Physical condition~" + f.getPhysicalCondition() + "~" +
                        "Number of goals~" + f.getGoalsNumber();
    }
    private String toString(List<Footballer> footballers) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < footballers.size(); i++) {
            res.append(toString(footballers.get(i)));
            if (i+1 < footballers.size()) {
                res.append(";");
            }
        }
        return res.toString();
    }
    private Footballer fromString(String s){
        String [] obj = s.split("~");
        Footballer res = new Footballer();
        res.setFirstname(obj[1]);
        res.setLastname(obj[3]);
        res.setDateOfBirth(LocalDate.parse(obj[5]));
        res.setPhysicalCondition(Footballer.PhysicalCondition.valueOf(obj[7]));
        res.setGoalsNumber(Integer.parseInt(obj[9]));
        return res;
    }

    private  List<Footballer> fromStringList(String s){
        String [] obj = s.split(";");
        List<Footballer> res = new ArrayList<>();
        for(String item:obj){
            res.add(fromString(item));
        }
        return res;
    }

    @Override
    public List<Footballer> listFromFile(String fileName) {
        try (
                FileReader fw = new FileReader(new File(fileName));
                BufferedReader bw = new BufferedReader(fw)) {
            return fromStringList(bw.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Footballer fromFile(String fileName) {
        try (
                FileReader fw = new FileReader(new File(fileName));
                BufferedReader bw = new BufferedReader(fw)) {
            return fromString(bw.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void toFile(Footballer footballer, String fileName) {
        try (
                FileWriter fw = new FileWriter(new File(fileName));
                BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(toString(footballer));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void listToFile(List<Footballer> footballers, String fileName) {
        try(
                FileWriter fw = new FileWriter(fileName);
                BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(toString(footballers));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[]) {
        Footballer footballer = new Footballer();
        footballer.setFirstname("Cristiano");
        footballer.setLastname("Ronaldo");
        footballer.setDateOfBirth(LocalDate.of(1985, 2, 5));
        footballer.setPhysicalCondition(Footballer.PhysicalCondition.healthy);
        footballer.setGoalsNumber(837);

        Serializer serializer = new SerializerTXT();
        serializer.toFile(footballer, "footballerTXT");


        List<Footballer> footballers = new ArrayList<>();
        footballers.add(footballer);

        footballer = new Footballer();
        footballer.setFirstname("Lionel");
        footballer.setLastname("Messi");
        footballer.setDateOfBirth(LocalDate.of(1987, 6, 24));
        footballer.setPhysicalCondition(Footballer.PhysicalCondition.healthy);
        footballer.setGoalsNumber(821);

        footballers.add(footballer);
        serializer.listToFile(footballers, "footballersTXT");

        footballer = serializer.fromFile("footballerTXT");
        System.out.println(footballer);
        footballers = serializer.listFromFile("footballersTXT");
        System.out.println(footballers);
    }
}