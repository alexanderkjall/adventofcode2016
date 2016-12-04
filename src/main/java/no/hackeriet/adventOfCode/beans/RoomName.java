package no.hackeriet.adventOfCode.beans;

import java.util.*;

public class RoomName {
    private String name;
    private int sectorId;
    private String checkSum;

    public RoomName(String name) {
        int split = name.indexOf('[');
        int dash = name.lastIndexOf('-');

        this.name = name.substring(0, dash);
        this.sectorId = Integer.valueOf(name.substring(dash + 1, split));
        this.checkSum = name.substring(split + 1, name.length() - 1);
    }

    public boolean verifyChecksum() {
        Map<Integer, Integer> occurrences = new HashMap<>();

        name.codePoints()
                .filter(c -> c != '-')
                .forEach(c -> {
                    if(!occurrences.containsKey(c))
                        occurrences.put(c, 1);
                    else
                        occurrences.put(c, occurrences.get(c) + 1);
                });

        List<Map.Entry<Integer, Integer>> chars = new ArrayList<>(occurrences.entrySet());

        Comparator<Map.Entry<Integer, Integer>> byKey = Comparator.comparing(Map.Entry::getKey);

        Comparator<Map.Entry<Integer, Integer>> byValue = (e1, e2) -> e2
                .getValue().compareTo(e1.getValue());;

        chars.sort(byValue.thenComparing(byKey));

        StringBuilder sum = new StringBuilder();
        sum.append(Character.toChars(chars.get(0).getKey()));
        sum.append(Character.toChars(chars.get(1).getKey()));
        sum.append(Character.toChars(chars.get(2).getKey()));
        sum.append(Character.toChars(chars.get(3).getKey()));
        sum.append(Character.toChars(chars.get(4).getKey()));

        return checkSum.equals(sum.toString());
    }

    @Override
    public String toString() {
        return name + '-' + sectorId + '[' + checkSum + ']';
    }

    public int getSectorId() {
        return sectorId;
    }

    public String getRotatedName(int rotations) {
        return name.codePoints()
                .mapToObj(c -> (char) ((c - 'a' + rotations) % 26 + 'a'))
                .collect(StringBuilder::new,
                StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
