package no.hackeriet.adventOfCode.beans;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LightArrayTest {
    @Test
    public void light1x1() throws Exception {
        LightArray la = new LightArray(1, 1);

        la.light(new LightInstruction("rect 1x1"));

        assertEquals(1, la.nrLit());
        assertEquals("*\n", la.toString());

        la.light(new LightInstruction("rotate row y=0 by 5"));

        assertEquals(1, la.nrLit());
        assertEquals("*\n", la.toString());
    }

    @Test
    public void light2x2() throws Exception {
        LightArray la = new LightArray(2, 2);

        la.light(new LightInstruction("rect 1x1"));

        assertEquals(1, la.nrLit());
        assertEquals("*#\n" +
                "##\n", la.toString());

        la.light(new LightInstruction("rotate row y=0 by 5"));

        assertEquals("#*\n" +
                "##\n", la.toString());
        assertEquals(1, la.nrLit());
    }
}