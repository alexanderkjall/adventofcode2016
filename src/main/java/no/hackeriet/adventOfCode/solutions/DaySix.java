package no.hackeriet.adventOfCode.solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class DaySix {
    public String errorCorrect(String input, boolean reversed) {
        Map<Integer, Map<Integer, AtomicInteger>> posToFreq = new ConcurrentHashMap<>();

        Arrays.stream(input.split("\\n"))
                //.parallel()
                .forEach(s -> {
                    for(int pos = 0; pos < s.length(); pos++) {
                        if(!posToFreq.containsKey(pos))
                            posToFreq.put(pos, new ConcurrentHashMap<>());

                        if(!posToFreq.get(pos).containsKey(s.codePointAt(pos)))
                            posToFreq.get(pos).put(s.codePointAt(pos), new AtomicInteger(1));
                        else
                            posToFreq.get(pos).get(s.codePointAt(pos)).addAndGet(1);
                    }
                });

        StringBuilder sb = new StringBuilder();

        if(reversed)
            posToFreq.entrySet()
                    .stream()
                    .sorted(Comparator.comparing(Map.Entry::getKey))
                    .forEach(e -> {
                        sb.append(Character.toChars(e.getValue().entrySet().stream()
                                .sorted(Comparator.comparing((Map.Entry<Integer, AtomicInteger> s) -> s.getValue().get()).reversed())
                                .findFirst().get().getKey()));
                    });
        else
            posToFreq.entrySet()
                    .stream()
                    .sorted(Comparator.comparing(Map.Entry::getKey))
                    .forEach(e -> {
                        sb.append(Character.toChars(e.getValue().entrySet().stream()
                                .sorted(Comparator.comparing(s -> s.getValue().get()))
                                .findFirst().get().getKey()));
                    });
        return sb.toString();
    }
}
