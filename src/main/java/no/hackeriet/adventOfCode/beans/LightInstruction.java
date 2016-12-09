package no.hackeriet.adventOfCode.beans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LightInstruction {
    public enum Command {
        RECT("rect"),
        COL("rotate column"),
        ROW("rotate row");

        private final String str;

        Command(String str) {
            this.str = str;
        }

        public String getStr() {
            return str;
        }
    }

    private Command c;
    private int x;
    private int y;
    private int dist;

    private static Pattern pRect = Pattern.compile("rect (\\d+)x(\\d+)");
    private static Pattern pCol = Pattern.compile("rotate column x=(\\d+) by (\\d+)");
    private static Pattern pRow = Pattern.compile("rotate row y=(\\d+) by (\\d+)");

    public LightInstruction(String s) {
        for(Command c : Command.values()) {
            if(s.startsWith(c.getStr()))
                this.c = c;
        }

        switch (c) {
            case RECT:
                Matcher m = pRect.matcher(s);
                if(!m.matches())
                    throw new IllegalArgumentException(s);

                x = Integer.parseInt(m.group(1));
                y = Integer.parseInt(m.group(2));
                break;
            case COL:
                m = pCol.matcher(s);
                if(!m.matches())
                    throw new IllegalArgumentException(s);

                x = Integer.parseInt(m.group(1));
                dist = Integer.parseInt(m.group(2));
                break;
            case ROW:
                m = pRow.matcher(s);
                if(!m.matches())
                    throw new IllegalArgumentException(s);

                y = Integer.parseInt(m.group(1));
                dist = Integer.parseInt(m.group(2));
                break;
        }
    }

    public Command getC() {
        return c;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDist() {
        return dist;
    }
}
