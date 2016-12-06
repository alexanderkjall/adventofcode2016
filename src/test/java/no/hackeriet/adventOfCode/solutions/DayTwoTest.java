package no.hackeriet.adventOfCode.solutions;

import no.hackeriet.adventOfCode.Util;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DayTwoTest {
    @Test
    public void press() throws Exception {
        assertEquals("[1, 9, 8, 5]", new DayTwo().press(Util.read("dayTwoExample")));
    }

}