package no.hackeriet.adventOfCode.solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DayNineTest {
    @Test
    public void inflateBasic() throws Exception {
        assertEquals(6, new DayNine().inflate("ADVENT", false));
    }

    @Test
    public void inflateOneSmallGroup() throws Exception {
        assertEquals(7, new DayNine().inflate("A(1x5)BC", false));
    }

    @Test
    public void inflateOneBigGroup() throws Exception {
        assertEquals(9, new DayNine().inflate("(3x3)XYZ", false));
    }

    @Test
    public void inflateTwoGroups() throws Exception {
        assertEquals(11, new DayNine().inflate("A(2x2)BCD(2x2)EFG", false));
    }

    @Test
    public void inflateOneHiddenGroup() throws Exception {
        assertEquals(6, new DayNine().inflate("(6x1)(1x3)A", false));
    }

    @Test
    public void inflateOneGroupTwoTimes() throws Exception {
        assertEquals(18, new DayNine().inflate("X(8x2)(3x3)ABCY", false));
    }

    @Test
    public void inflateV2Basic() throws Exception {
        assertEquals(9, new DayNine().inflate("(3x3)XYZ", true));
    }

    @Test
    public void inflateV2TwoGroupThreeTimes() throws Exception {
        assertEquals(20, new DayNine().inflate("X(8x2)(3x3)ABCY", true));
    }

    @Test
    public void inflateV2A() throws Exception {
        assertEquals(241920, new DayNine().inflate("(27x12)(20x12)(13x14)(7x10)(1x12)A", true));
    }

    @Test
    public void inflateV2Seven() throws Exception {
        assertEquals(445, new DayNine().inflate("(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN", true));
    }

}