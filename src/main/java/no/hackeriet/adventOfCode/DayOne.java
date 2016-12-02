package no.hackeriet.adventOfCode;

import no.hackeriet.adventOfCode.beans.Coordinate;
import no.hackeriet.adventOfCode.beans.Instruction;
import no.hackeriet.adventOfCode.beans.Position;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DayOne {

    public void walk(String directions) {
        Position p = new Position();

        Arrays.stream(directions.split(", |\\n"))
                .map(Instruction::new)
                .forEach(p::go);

        System.out.println("Solution day one.1: " + Math.abs(p.getX()) + Math.abs(p.getY()));

        Set<Coordinate> seen = new HashSet<>();
        final boolean[] printed = {false};
        p.getOldCoords().stream().forEach(c -> {
            if (!printed[0] && seen.contains(c)) {
                System.out.println("Solution day one.2: " + Math.abs(c.getX()) + Math.abs(c.getY()));
                printed[0] = true;
            }
            seen.add(c);
        });
    }
}
