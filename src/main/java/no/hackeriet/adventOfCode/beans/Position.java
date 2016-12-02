package no.hackeriet.adventOfCode.beans;

import static no.hackeriet.adventOfCode.beans.Direction.north;

public class Position {
    private int x;
    private int y;

    private Direction facing = north;

    public void go(Instruction i) {
        facing = Direction.values()[(facing.getI() + (i.getT() == Turn.right? 1 : -1) + 4) % 4];

        switch (facing) {
            case north:
                y += i.getDistance();
                break;
            case east:
                x += i.getDistance();
                break;
            case south:
                y -= i.getDistance();
                break;
            case west:
                x -= i.getDistance();
                break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
