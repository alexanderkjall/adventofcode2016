package no.hackeriet.adventOfCode.beans;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IPv7Test {
    @Test
    public void verifyABA1() throws Exception {
        assertTrue(new IPv7("abba[mnop]qrst").verifyABA());
    }

    @Test
    public void verifyABA2() throws Exception {
        assertFalse(new IPv7("abcd[bddb]xyyx").verifyABA());
    }

    @Test
    public void verifyABA3() throws Exception {
        assertFalse(new IPv7("aaaa[qwer]tyui").verifyABA());
    }

    @Test
    public void verifyABA4() throws Exception {
        assertTrue(new IPv7("ioxxoj[asdfgh]zxcvbn").verifyABA());
    }

    @Test
    public void verifyABA5() throws Exception {
        assertFalse(new IPv7("tivuddusgnewzshs[mausfjbgxmyibin]yponuityptavbhekrlg[qeyafuevtlqemtfa]owtdxadrwwbxbrkl[obfcyxbifipwhduudu]mjocivgvrcbrllso").verifyABA());
    }

    @Test
    public void verifyBAB1() throws Exception {
        assertTrue(new IPv7("aba[bab]xyz").verifyBAB());
    }

    @Test
    public void verifyBAB2() throws Exception {
        assertFalse(new IPv7("xyx[xyx]xyx").verifyBAB());
    }

    @Test
    public void verifyBAB3() throws Exception {
        assertTrue(new IPv7("aaa[kek]eke").verifyBAB());
    }

    @Test
    public void verifyBAB4() throws Exception {
        assertTrue(new IPv7("zazbz[bzb]cdb").verifyBAB());
    }
}