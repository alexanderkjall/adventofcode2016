package no.hackeriet.adventOfCode.solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DayNineTest {
    @Test
    public void inflateBasic() throws Exception {
        assertEquals(6, new DayNine().inflate("ADVENT"));
    }

    @Test
    public void inflateOneSmallGroup() throws Exception {
        assertEquals(7, new DayNine().inflate("A(1x5)BC"));
    }

    @Test
    public void inflateOneBigGroup() throws Exception {
        assertEquals(9, new DayNine().inflate("(3x3)XYZ"));
    }

    @Test
    public void inflateTwoGroups() throws Exception {
        assertEquals(11, new DayNine().inflate("A(2x2)BCD(2x2)EFG"));
    }

    @Test
    public void inflateOneHiddenGroup() throws Exception {
        assertEquals(6, new DayNine().inflate("(6x1)(1x3)A"));
    }

    @Test
    public void inflateOneGroupTwoTimes() throws Exception {
        assertEquals(18, new DayNine().inflate("X(8x2)(3x3)ABCY"));
    }

}