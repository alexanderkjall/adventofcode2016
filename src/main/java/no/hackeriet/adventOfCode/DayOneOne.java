package no.hackeriet.adventOfCode;

import no.hackeriet.adventOfCode.beans.Instruction;
import no.hackeriet.adventOfCode.beans.Position;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class DayOneOne {
    private String read(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(DayOneOne.class.getClassLoader().getResource(filePath).getFile())));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void walk() {
        String directions = read("dayOneOne_input");

        Position p = new Position();

        Arrays.stream(directions.split(", |\\n"))
                .map(Instruction::new)
                .forEach(p::go);

        System.out.println(Math.abs(p.getX()) + Math.abs(p.getY()));
    }
}
