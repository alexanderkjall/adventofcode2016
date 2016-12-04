package no.hackeriet.adventOfCode.solutions;

import no.hackeriet.adventOfCode.beans.RoomName;

import java.util.Arrays;

public class DayFour {

    public int sumRooms(String input) {
        return Arrays.stream(input.split("\\n"))
                .map(RoomName::new)
                .mapToInt(r -> {
                    if(r.verifyChecksum())
                        return r.getSectorId();
                    return 0;
                })
                .sum();
    }

    public int decryptRooms(String input) {
        return Arrays.stream(input.split("\\n"))
                .map(RoomName::new)
                .mapToInt(r -> {
                    if(r.verifyChecksum() && r.getRotatedName(r.getSectorId()).equals("northpolecobjectcstorage"))
                        return r.getSectorId();

                    return 0;
                })
                .sum();
    }
}
