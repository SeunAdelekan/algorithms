package hackerrank.problemsolving;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iyanu Adelekan on 03/02/2019.
 */
public class TimeInWords {

    public static void main(String[] args) {
        System.out.println(timeInWords(4, 46));
    }

    private static String timeInWords(int h, int m) {
        String minute = getMinuteDictionary().get(String.valueOf(m));
        String hour = getHourDictionary().get(h);
        StringBuilder builder = new StringBuilder();

        if (m == 0) {
            builder.append(hour).append(" o' clock");
        } else if (m <= 30) {
            builder.append(minute).append(" past ").append(hour);
        } else {
            minute = getMinuteDictionary().get(String.valueOf(60 - m));
            hour = getHourDictionary().get(h + 1);
            builder.append(minute).append(" to ").append(hour);
        }

        return builder.toString();
    }

    private static Map<Integer, String> getHourDictionary() {
        final Map<Integer, String> map = new HashMap<>();

        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");

        return map;
    }

    private static Map<String, String> getMinuteDictionary() {
        final Map<String, String> map = new HashMap<>();

        map.put("1", "one minute");
        map.put("2", "two minutes");
        map.put("3", "three minutes");
        map.put("4", "four minutes");
        map.put("5", "five minutes");
        map.put("6", "six minutes");
        map.put("7", "seven minutes");
        map.put("8", "eight minutes");
        map.put("9", "nine minutes");
        map.put("10", "ten minutes");
        map.put("11", "eleven minutes");
        map.put("12", "twelve minutes");
        map.put("13", "thirteen minutes");
        map.put("14", "fourteen minutes");
        map.put("15", "quarter");
        map.put("16", "sixteen minutes");
        map.put("17", "seventeen minutes");
        map.put("18", "eighteen minutes");
        map.put("19", "nineteen minutes");
        map.put("20", "twenty minutes");
        map.put("21", "twenty one minutes");
        map.put("22", "twenty two minutes");
        map.put("23", "twenty three minutes");
        map.put("24", "twenty four minutes");
        map.put("25", "twenty five minutes");
        map.put("26", "twenty six minutes");
        map.put("27", "twenty seven minutes");
        map.put("28", "twenty eight minutes");
        map.put("29", "twenty nine minutes");
        map.put("30", "half");

        return map;
    }
}
