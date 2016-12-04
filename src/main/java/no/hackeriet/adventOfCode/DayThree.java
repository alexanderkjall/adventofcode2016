package no.hackeriet.adventOfCode;

import no.hackeriet.adventOfCode.beans.Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayThree {

    public int calc(String input) {
        return Arrays.stream(input.split("\\n"))
                .map(this::parse)
                .mapToInt(t -> t.valid() ? 1 : 0)
                .sum();
    }

    public int calcAgain(String input) {
        List<Integer> buffer = new ArrayList<>(9);
        List<Triangle> reOrdered = new ArrayList<>();
        Arrays.stream(input.split("\\n| +"))
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .forEach(i -> {
                    buffer.add(i);
                    if(buffer.size() == 9) {
                        reOrdered.add(new Triangle(buffer.get(0), buffer.get(3), buffer.get(6)));
                        reOrdered.add(new Triangle(buffer.get(1), buffer.get(4), buffer.get(7)));
                        reOrdered.add(new Triangle(buffer.get(2), buffer.get(5), buffer.get(8)));
                        buffer.clear();
                    }
                });

        return reOrdered.stream()
                .mapToInt(t -> t.valid() ? 1 : 0)
                .sum();
    }

    public Triangle parse(String line) {
        String[] sides = line.split(" +");

        return new Triangle(Integer.parseInt(sides[1]), Integer.parseInt(sides[2]), Integer.parseInt(sides[3]));
    }
}
