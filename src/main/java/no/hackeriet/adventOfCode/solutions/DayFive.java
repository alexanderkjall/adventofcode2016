package no.hackeriet.adventOfCode.solutions;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class DayFive {
    public String hash(String input) throws NoSuchAlgorithmException {

        StringBuilder sb = new StringBuilder();

        Map<Integer, Character> map = new ConcurrentHashMap<>();
        IntStream
                .iterate(0, i -> i + 1)
                .parallel()
                .peek(i -> {
                    try {
                        MessageDigest md = MessageDigest.getInstance("MD5");

                        md.update((input + i).getBytes(StandardCharsets.ISO_8859_1));

                        String s = String.format("%032x", new BigInteger(1, md.digest()));

                        if(s.startsWith("00000")) {
                            map.put(i, s.charAt(5));
                        }
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }
                })
                .allMatch(n -> map.size() < 8);

        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(e -> sb.append(e.getValue()));

        return sb.toString();
    }

    public String hashSecond(String input) {

        StringBuilder sb = new StringBuilder();

        Map<Integer, Character> map = new ConcurrentHashMap<>();
        IntStream
                .iterate(0, i -> i + 1)
                .parallel()
                .peek(i -> {
                    try {
                        MessageDigest md = MessageDigest.getInstance("MD5");

                        md.update((input + i).getBytes(StandardCharsets.ISO_8859_1));

                        String s = String.format("%032x", new BigInteger(1, md.digest()));

                        if(s.startsWith("00000")) {
                            try {
                                int num = Integer.parseInt(String.valueOf(s.charAt(5)));
                                if (num < 8 && !map.containsKey(num))
                                    map.put(num, s.charAt(6));
                            } catch (NumberFormatException ignore) {
                            }
                        }
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }
                })
                .allMatch(n -> map.size() < 8);

        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(e -> sb.append(e.getValue()));

        return sb.toString();
    }
}
