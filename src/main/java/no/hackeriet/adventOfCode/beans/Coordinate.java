package no.hackeriet.adventOfCode.beans;

import java.util.Objects;

public class Coordinate implements Comparable<Coordinate> {
    private int x;
    private int y;

    public Coordinate() {
    }

    public Coordinate(Coordinate coord) {
        x = coord.x;
        y = coord.y;
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Coordinate o) {
        int diff = x - o.x;
        if(diff == 0)
            diff = y - o.y;

        return diff;
    }

    @Override
    public String toString() {
        return x + "x" + y;
    }
}