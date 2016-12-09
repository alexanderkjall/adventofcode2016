package no.hackeriet.adventOfCode.solutions;

public class DayNine {
    private enum States {
        NORMAL,
        BUF_LENGTH,
        BUF_REPS,
        BUF
    }

    public long inflate(String input, boolean v2) {
        return expand(input, v2);
    }

    private long expand(String input, boolean v2) {
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
                                try {
                                    Thread.sleep(200);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                if(v2)
                                    res = expand(subBuf.toString(), true);
                                else
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
