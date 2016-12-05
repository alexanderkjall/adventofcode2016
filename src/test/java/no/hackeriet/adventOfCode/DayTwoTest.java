package no.hackeriet.adventOfCode;

import no.hackeriet.adventOfCode.solutions.DayTwo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DayTwoTest {
    @Test
    public void press() throws Exception {
        assertEquals("[1, 9, 8, 5]", new DayTwo().press(Util.read("dayTwoExample")));
    }

}