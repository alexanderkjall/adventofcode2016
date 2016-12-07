package no.hackeriet.adventOfCode.solutions;

import no.hackeriet.adventOfCode.beans.IPv7;

import java.util.Arrays;

public class DaySeven {
    public int checkTLS(String input) {
        return Arrays.stream(input.split("\\n"))
                .map(IPv7::new)
                .mapToInt(r -> {
                    if(r.verifyABA())
                        return 1;
                    return 0;
                })
                .sum();
    }

    public int checkSSL(String input) {
        return Arrays.stream(input.split("\\n"))
                .map(IPv7::new)
                .mapToInt(r -> {
                    if(r.verifyBAB())
                        return 1;
                    return 0;
                })
                .sum();
    }
}
