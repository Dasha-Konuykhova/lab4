package org.example;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CSVReader personReader = new CSVReader("foreign_names.csv", ';');
        List<Person> list = new LinkedList<>(personReader.getPeople());

    }
}