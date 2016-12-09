package no.hackeriet.adventOfCode.solutions;

import no.hackeriet.adventOfCode.beans.LightArray;
import no.hackeriet.adventOfCode.beans.LightInstruction;

import java.util.Arrays;

public class DayEight {
    public int lightPixels(String input) {
        LightArray la = new LightArray(50, 6);
        Arrays.stream(input.split("\\n"))
                .map(LightInstruction::new)
                .forEach(la::light);

        System.out.println("Solution day eight.2:\n" + la);

        return la.nrLit();
    }
}
