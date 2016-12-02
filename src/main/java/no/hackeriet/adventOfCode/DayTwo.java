package no.hackeriet.adventOfCode;

import no.hackeriet.adventOfCode.beans.Coordinate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayTwo {
    private static Coordinate start = new Coordinate(0, 0);

    public void press(String instructions) {
        List<Integer> presses = new ArrayList<>();

        Arrays.stream(instructions.split("\\n"))
                .forEach(s -> ("0" + s).codePoints()
                        .mapToObj(DayTwo::toCoord)
                        .reduce(DayTwo::add)
                        .map(c -> presses.add(toPress(c))));

        System.out.println("Solution day two.1: " + presses);
    }

    private Integer toPress(Coordinate c) {
        if(c.getX() == -1) {
            if(c.getY() == -1) {
                return 7;
            } else if(c.getY() == 0) {
                return 4;
            } else if(c.getY() == 1) {
                return 1;
            }
        } else if(c.getX() == 0) {
            if(c.getY() == -1) {
                return 8;
            } else if(c.getY() == 0) {
                return 5;
            } else if(c.getY() == 1) {
                return 2;
            }
        } else if(c.getX() == 1) {
            if(c.getY() == -1) {
                return 9;
            } else if(c.getY() == 0) {
                return 6;
            } else if(c.getY() == 1) {
                return 3;
            }
        }
        return null;
    }

    public static Coordinate add(Coordinate c1, Coordinate c2) {
        int x = c1.getX() + c2.getX();
        int y = c1.getY() + c2.getY();

        if(x < -1 || x > 1 || y < -1 || y > 1)
            return c1;

        c1.setX(x);
        c1.setY(y);
        return c1;
    }

    public static Coordinate toCoord(int c) {
        if(c == '0') {
            return start;
        }
        if(c == 'U')
            return new Coordinate(0, 1);
        if(c == 'R')
            return new Coordinate(1, 0);
        if(c == 'D')
            return new Coordinate(0, -1);
        if(c == 'L')
            return new Coordinate(-1, 0);
        return null;
    }
}
