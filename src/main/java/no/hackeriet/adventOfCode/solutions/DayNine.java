package no.hackeriet.adventOfCode.solutions;

import java.util.HashMap;
import java.util.Map;

public class DayNine {
    private enum States {
        NORMAL,
        BUF_LENGTH,
        BUF_REPS,
        BUF
    }

    private Map<String, Long> cache = new HashMap<>();

    public long inflate(String input, boolean v2) {
        final long[] result = {0};
        StringBuilder subBuf = new StringBuilder();

        final States[] state = {States.NORMAL};
        final int[] length = {0};
        final int[] reps = {0};

        input.chars()
                .forEach(c -> {
                    char cs = (char)c;

                    switch (state[0]) {
                        case NORMAL:
                            if(c == '(') {
                                state[0] = States.BUF_LENGTH;
                            } else {
                                result[0]++;
                            }
                            break;
                        case BUF_LENGTH:
                            if(c == 'x') {
                                length[0] = Integer.parseInt(subBuf.toString());
                                subBuf.setLength(0);
                                state[0] = States.BUF_REPS;
                            } else {
                                subBuf.append(cs);
                            }
                            break;
                        case BUF_REPS:
                            if(c == ')') {
                                reps[0] = Integer.parseInt(subBuf.toString());
                                subBuf.setLength(0);
                                state[0] = States.BUF;
                            } else {
                                subBuf.append(cs);
                            }
                            break;
                        case BUF:
                            subBuf.append(cs);

                            length[0]--;

                            if(length[0] <= 0) {
                                long res;
                                if(v2) {
                                    if(cache.containsKey(subBuf.toString()))
                                        res = cache.get(subBuf.toString());
                                    else {
                                        res = inflate(subBuf.toString(), true);
                                        cache.put(subBuf.toString(), res);
                                    }
                                } else
                                    res = subBuf.toString().length();

                                for(int i = 0; i < reps[0]; i++) {
                                    result[0] += res;
                                }

                                subBuf.setLength(0);
                                state[0] = States.NORMAL;
                            }
                            break;
                    }
                });

        return result[0];
    }
}
