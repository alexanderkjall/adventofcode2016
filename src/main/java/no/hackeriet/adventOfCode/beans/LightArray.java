package no.hackeriet.adventOfCode.beans;

import java.util.ArrayList;
import java.util.List;

public class LightArray {
    private List<Boolean> lights;

    private int width;
    private int height;

    public LightArray(int x, int y) {
        lights = new ArrayList<>(x * y);
        for(int i = 0; i < x * y; i++) {
            lights.add(false);
        }
        width = x;
        height = y;
    }

    public int nrLit() {
        return lights.stream()
                .mapToInt(b -> b ? 1 : 0)
                .sum();
    }

    public void light(LightInstruction li) {
        switch (li.getC()) {
            case RECT:
                for(int x = 0; x < li.getX(); x++) {
                    for(int y = 0; y < li.getY(); y++) {
                        lights.set(x + y * width, true);
                    }
                }
                break;
            case COL:
                for(int i = 0; i < li.getDist(); i++) {
                    boolean carry = lights.get(li.getX() + width * (height - 1));
                    for (int y = 0; y < height; y++) {
                        boolean b = lights.get(li.getX() + width * y);
                        lights.set(li.getX() + width * y, carry);
                        carry = b;
                    }
                }
                break;
            case ROW:
                for(int i = 0; i < li.getDist(); i++) {
                    boolean carry = lights.get((li.getY() + 1) * width - 1);
                    for (int x = 0; x < width; x++) {
                        boolean b = lights.get(li.getY() * width + x);
                        lights.set(li.getY() * width + x, carry);
                        carry = b;
                    }
                }
                break;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                if(lights.get(x + y * width))
                    sb.append("*");
                else
                    sb.append("#");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
