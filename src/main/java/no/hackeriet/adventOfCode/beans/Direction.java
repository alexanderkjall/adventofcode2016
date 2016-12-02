package no.hackeriet.adventOfCode.beans;

public enum Direction {
    north(0),
    east(1),
    south(2),
    west(3);

    private final int i;

    Direction(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}
