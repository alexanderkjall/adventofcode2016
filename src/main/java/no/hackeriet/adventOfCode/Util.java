package no.hackeriet.adventOfCode;

import no.hackeriet.adventOfCode.solutions.DayOne;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {
    static String read(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(DayOne.class.getClassLoader().getResource(filePath).getFile())));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
