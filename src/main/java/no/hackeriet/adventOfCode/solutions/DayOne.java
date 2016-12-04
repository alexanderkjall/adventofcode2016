package no.hackeriet.adventOfCode.solutions;

import no.hackeriet.adventOfCode.beans.Coordinate;
import no.hackeriet.adventOfCode.beans.Instruction;
import no.hackeriet.adventOfCode.beans.Position;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DayOne {

    private Position p = new Position();

    public int walk(String directions) {

        Arrays.stream(directions.split(", |\\n"))
                .map(Instruction::new)
                .forEach(p::go);

        return Math.abs(p.getX()) + Math.abs(p.getY());
    }

    public int walkAgain() {
        Set<Coordinate> seen = new HashSet<>();
        final boolean[] printed = {false};
        final int[] solution = {0};
        p.getOldCoords().forEach(c -> {
            if (!printed[0] && seen.contains(c)) {
                solution[0] = Math.abs(c.getX()) + Math.abs(c.getY());
                printed[0] = true;
            }
            seen.add(c);
        });

        return solution[0];
    }
}
