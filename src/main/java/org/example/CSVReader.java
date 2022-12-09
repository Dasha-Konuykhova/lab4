package org.example;


import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * class for reading information about a person from a CSV-file
 */
public class CSVReader {

    StringBuilder str;
    List<Person> People;
    char separator;

    /**
     * Get information about a person in the form of a list
     *
     * @return - list
     */
    public List<Person> getPeople() {
        return People;
    }

    /**
     * Splits a string into fields of the Person class by the separator character
     *
     * @return - string
     */
    String separateString() {
        StringBuilder str1 = new StringBuilder();
        int i = 0;
        for (; str.charAt(i) != separator; i++)
            str1.append(str.charAt(i));
        str.delete(0, i + 1);
        return str1.toString();
    }

    /**
     * Initializes an object of the Person class
     *
     * @param stringBuilder - list CSV-file
     * @return - an object of the Person class
     */
    Person fillPerson(String stringBuilder) {
        this.str = new StringBuilder(stringBuilder);
        this.str.delete(0, 1);
        this.str.delete(this.str.length() - 1, this.str.length());

        Person filler = new Person();
        filler.id = Integer.parseInt(separateString());
        filler.name = separateString();
        filler.gender = separateString();
        filler.birtdate = separateString();
        filler.division = new Division(separateString());
        filler.salary = Integer.parseInt(this.str.toString());

        return filler;
    }

    /**
     * The class constructor reads CSV-file to list
     *
     * @param file_name
     * @param separator
     */
    CSVReader(String file_name, char separator) {
        People = new LinkedList<>();
        this.separator = separator;
        try {
            com.opencsv.CSVReader reader = new com.opencsv.CSVReader(new FileReader(file_name));
            String[] nextLine;
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                People.add(fillPerson(Arrays.toString(nextLine)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}