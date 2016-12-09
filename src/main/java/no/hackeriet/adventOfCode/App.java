package no.hackeriet.adventOfCode;

import no.hackeriet.adventOfCode.solutions.*;

import java.security.NoSuchAlgorithmException;

public class App {

    private static DayOne d1 = new DayOne();
    private static DayTwo d2 = new DayTwo();
    private static DayThree d3 = new DayThree();
    private static DayFour d4 = new DayFour();
    private static DayFive d5 = new DayFive();
    private static DaySix d6 = new DaySix();
    private static DaySeven d7 = new DaySeven();
    private static DayEight d8 = new DayEight();
    private static DayNine d9 = new DayNine();

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("Solution day one.1: " + d1.walk(Util.read("dayOne_input")));
        System.out.println("Solution day one.2: " + d1.walkAgain());
        System.out.println("Solution day two.1: " + d2.press(Util.read("dayTwo_input")));
        System.out.println("Solution day two.2: " + d2.pressDiagonal(Util.read("dayTwo_input")));
        System.out.println("Solution day three.1: " + d3.calc(Util.read("dayThree_input")));
        System.out.println("Solution day three.2: " + d3.calcAgain(Util.read("dayThree_input")));
        System.out.println("Solution day four.1: " + d4.sumRooms(Util.read("dayFour_input")));
        System.out.println("Solution day four.2: " + d4.decryptRooms(Util.read("dayFour_input")));
        //System.out.println("Solution day five.1: " + d5.hash("cxdnnyjw"));
        //System.out.println("Solution day five.2: " + d5.hashSecond("cxdnnyjw"));
        System.out.println("Solution day six.1: " + d6.errorCorrect(Util.read("daySix_input"), true));
        System.out.println("Solution day six.2: " + d6.errorCorrect(Util.read("daySix_input"), false));
        System.out.println("Solution day seven.1: " + d7.checkTLS(Util.read("daySeven_input")));
        System.out.println("Solution day seven.2: " + d7.checkSSL(Util.read("daySeven_input")));
        System.out.println("Solution day eight.1: " + d8.lightPixels(Util.read("dayEight_input")));
        System.out.println("Solution day nine.1: " + d9.inflate(Util.read("dayNine_input")));
    }
}
