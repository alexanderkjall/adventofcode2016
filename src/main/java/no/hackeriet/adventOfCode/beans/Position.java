package no.hackeriet.adventOfCode.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static no.hackeriet.adventOfCode.beans.Direction.north;

public class Position {
    private Coordinate coord = new Coordinate();
    private Direction facing = north;

    List<Coordinate> oldCoords = new ArrayList<>();

    public void go(Instruction i) {
        facing = Direction.values()[(facing.getI() + (i.getT() == Turn.right? 1 : -1) + 4) % 4];

        switch (facing) {
            case north:
                IntStream.range(coord.getY(), coord.getY() + i.getDistance()).forEach(y -> oldCoords.add(new Coordinate(coord.getX(), y)));
                coord.setY(coord.getY() + i.getDistance());
                break;
            case east:
                IntStream.range(coord.getX(), coord.getX() + i.getDistance()).forEach(x -> oldCoords.add(new Coordinate(x, coord.getY())));
                coord.setX(coord.getX() + i.getDistance());
                break;
            case south:
                IntStream.range(coord.getY(), coord.getY() - i.getDistance()).forEach(y -> oldCoords.add(new Coordinate(coord.getX(), y)));
                coord.setY(coord.getY() - i.getDistance());
                break;
            case west:
                IntStream.range(coord.getX(), coord.getX() - i.getDistance()).forEach(x -> oldCoords.add(new Coordinate(x, coord.getY())));
                coord.setX(coord.getX() - i.getDistance());
                break;
        }
    }

    public int getX() {
        return coord.getX();
    }

    public int getY() {
        return coord.getY();
    }

    public List<Coordinate> getOldCoords() {
        return oldCoords;
    }
}
