package serealization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lab1.footballclub.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class SerializerJSON implements Serializer{
    private ObjectMapper objectMapper;
    public SerializerJSON(){
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
    @Override
    public List<Footballer> listFromFile(String fileName) {
        try {
            return objectMapper.readValue(new File(fileName), new TypeReference<>() {
            });
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }
    @Override
    public Footballer fromFile(String fileName){
        try {
            return objectMapper.readValue(new File(fileName), Footballer.class);
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public void toFile(Footballer footballer, String fileName){
        try {
            objectMapper.writeValue(new File(fileName), footballer);
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }
    @Override
    public void listToFile(List<Footballer> footballers, String fileName){
        try {
            objectMapper.writeValue(new File(fileName), footballers);
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    public static void main(String args[]) {
        Footballer footballer = new Footballer();
        footballer.setFirstname("Cristiano");
        footballer.setLastname("Ronaldo");
        footballer.setDateOfBirth(LocalDate.of(1985, 2, 5));
        footballer.setPhysicalCondition(Footballer.PhysicalCondition.healthy);
        footballer.setGoalsNumber(837);

        Serializer serializer = new SerializerJSON();
        serializer.toFile(footballer, "footballerJSON");

        List<Footballer> footballers = new ArrayList<>();
        footballers.add(footballer);

        footballer = new Footballer();
        footballer.setFirstname("Lionel");
        footballer.setLastname("Messi");
        footballer.setDateOfBirth(LocalDate.of(1987, 6, 24));
        footballer.setPhysicalCondition(Footballer.PhysicalCondition.healthy);
        footballer.setGoalsNumber(821);
        footballers.add(footballer);
        serializer.listToFile(footballers, "footballersJSON");

        footballer = serializer.fromFile("footballerJSON");
        System.out.println(footballer);
        footballers = serializer.listFromFile("footballersJSON");
        System.out.println(footballers);
    }
}