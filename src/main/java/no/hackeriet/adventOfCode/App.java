package no.hackeriet.adventOfCode;

public class App {

    private static DayOne d1 = new DayOne();
    private static DayTwo d2 = new DayTwo();
    private static DayThree d3 = new DayThree();

    public static void main(String[] args) {
        System.out.println("Solution day one.1: " + d1.walk(Util.read("dayOne_input")));
        System.out.println("Solution day one.2: " + d1.walkAgain());
        System.out.println("Solution day two.1: " + d2.press(Util.read("dayTwo_input")));
        System.out.println("Solution day two.2: " + d2.pressDiagonal(Util.read("dayTwo_input")));
        System.out.println("Solution day three.1: " + d3.calc(Util.read("dayThree_input")));
        System.out.println("Solution day three.2: " + d3.calcAgain(Util.read("dayThree_input")));
    }
}
