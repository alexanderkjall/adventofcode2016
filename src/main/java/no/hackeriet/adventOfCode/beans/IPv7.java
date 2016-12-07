package no.hackeriet.adventOfCode.beans;

import java.util.ArrayList;
import java.util.List;

public class IPv7 {
    private List<String> seqs = new ArrayList<>();
    private List<String> hyperSeqs = new ArrayList<>();

    public IPv7(String s) {
        StringBuilder sb = new StringBuilder();

        s.codePoints()
                .forEach(c -> {
                    char[] chs = Character.toChars(c);
                    if(chs[0] == '[') {
                        seqs.add(sb.toString());
                        sb.setLength(0);
                        return;
                    }
                    if(chs[0] == ']') {
                        hyperSeqs.add(sb.toString());
                        sb.setLength(0);
                        return;
                    }
                    sb.append(chs);
                });
        seqs.add(sb.toString());
    }

    public boolean verifyABA() {
        return hasABA(seqs) && !hasABA(hyperSeqs);
    }

    private boolean hasABA(List<String> sq) {
        for(String s : sq)
            if (locateABA(s))
                return true;

        return false;
    }

    private boolean locateABA(String p) {
        for(int i = 1; i < p.length() - 2; i++) {
            if(p.charAt(i) == p.charAt(i + 1) && p.charAt(i - 1) == p.charAt(i + 2) && p.charAt(i) != p.charAt(i - 1))
                return true;
        }
        return false;
    }
}
