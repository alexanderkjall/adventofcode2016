package no.hackeriet.adventOfCode;

import no.hackeriet.adventOfCode.beans.Triangle;

import java.util.Arrays;

public class DayThree {

    public void calc(String input) {
        int nrOfValid = Arrays.stream(input.split("\\n"))
                .map(this::parse)
                .mapToInt(t -> t.valid() ? 1 : 0)
                .sum();

        System.out.println("Solution day three.1: " + nrOfValid);
    }

    public Triangle parse(String line) {
        String[] sides = line.split(" +");

        return new Triangle(Integer.parseInt(sides[1]), Integer.parseInt(sides[2]), Integer.parseInt(sides[3]));
    }
}
