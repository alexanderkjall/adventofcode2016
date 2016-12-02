package no.hackeriet.adventOfCode.beans;

public class Instruction {
    private Turn t;
    private int distance;

    public Instruction(String s) {
        if(s.charAt(0) == 'L')
            t = Turn.left;
        else
            t = Turn.right;

        distance = Integer.parseInt(s.substring(1));
    }

    public Turn getT() {
        return t;
    }

    public int getDistance() {
        return distance;
    }
}
