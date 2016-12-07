package no.hackeriet.adventOfCode.solutions;

import no.hackeriet.adventOfCode.Util;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DaySevenTest {
    @Test
    public void checkTLS() throws Exception {
        assertEquals(2, new DaySeven().checkTLS(Util.read("daySevenExample")));
    }

}