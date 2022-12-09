package org.example;


import java.util.Random;

/**
 * Information about the division
 */
public class Division {
    int id;
    String name;
    Division(String name) {
        this.name = name;
        Random random = new Random();
        id = random.nextInt();
    }
}
