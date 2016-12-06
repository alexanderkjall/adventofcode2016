package no.hackeriet.adventOfCode.solutions;

import no.hackeriet.adventOfCode.Util;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DaySixTest {
    @Test
    public void errorCorrect() throws Exception {
        assertEquals("easter", new DaySix().errorCorrect(Util.read("daySixExample")));
    }
}