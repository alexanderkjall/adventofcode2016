package no.hackeriet.adventOfCode.solutions;

import no.hackeriet.adventOfCode.beans.Coordinate;

import java.util.*;

public class DayTwo {
    private static Coordinate start = new Coordinate(0, 0);
    private static Coordinate startDiagonal = new Coordinate(-2, 0);

    private static Map<Coordinate, Character> valid = new HashMap<>();
    static {
        valid.put(new Coordinate(-2, 0), '5');
        valid.put(new Coordinate(-1, -1), 'A');
        valid.put(new Coordinate(-1, 0), '6');
        valid.put(new Coordinate(-1, 1), '2');
        valid.put(new Coordinate(0, -2), 'D');
        valid.put(new Coordinate(0, -1), 'B');
        valid.put(new Coordinate(0, 0), '7');
        valid.put(new Coordinate(0, 1), '3');
        valid.put(new Coordinate(0, 2), '1');
        valid.put(new Coordinate(1, -1), 'C');
        valid.put(new Coordinate(1, 0), '8');
        valid.put(new Coordinate(1, 1), '4');
        valid.put(new Coordinate(2, 0), '9');
    }

    public String press(String instructions) {
        List<Integer> presses = new ArrayList<>();

        Arrays.stream(instructions.split("\\n"))
                .forEach(s -> ("0" + s).codePoints()
                        .mapToObj(DayTwo::toCoord)
                        .reduce(DayTwo::add)
                        .map(c -> presses.add(toPress(c))));

        return presses.toString();
    }

    public String pressDiagonal(String instructions) {
        List<Character> pressesDiagonal = new ArrayList<>();

        Arrays.stream(instructions.split("\\n"))
                .forEach(s -> ("1" + s).codePoints()
                        .mapToObj(DayTwo::toCoord)
                        .reduce(DayTwo::addDiagonal)
                        .map(c -> pressesDiagonal.add(toPressDiagonal(c))));

        return pressesDiagonal.toString();
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

    private Character toPressDiagonal(Coordinate c) {
        return valid.get(c);
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

    public static Coordinate addDiagonal(Coordinate c1, Coordinate c2) {
        int x = c1.getX() + c2.getX();
        int y = c1.getY() + c2.getY();

        if(!valid.containsKey(new Coordinate(x, y)))
            return c1;

        c1.setX(x);
        c1.setY(y);
        return c1;
    }

    public static Coordinate toCoord(int c) {
        if(c == '0')
            return start;
        if(c == '1')
            return startDiagonal;
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
