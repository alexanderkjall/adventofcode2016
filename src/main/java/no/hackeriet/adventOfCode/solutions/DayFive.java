package no.hackeriet.adventOfCode.solutions;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DayFive {
    public String hash(String input) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            md.update((input + i).getBytes(StandardCharsets.ISO_8859_1));

            String s = String.format("%032x", new BigInteger(1, md.digest()));

            if(s.startsWith("00000")) {
                sb.append(s.charAt(5));
            }

            if(sb.length() == 8)
                return sb.toString();

            md.reset();
        }

        return "";
    }
}
