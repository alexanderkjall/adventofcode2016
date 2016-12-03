package no.hackeriet.adventOfCode;

public class App {
    public static void main(String[] args) {
        new DayOne().walk(Util.read("dayOne_input"));
        new DayTwo().press(Util.read("dayTwo_input"));
    }
}
