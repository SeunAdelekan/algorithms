package leetcode.easy;

/**
 * @author Iyanu Adelekan on 25/12/2018.
 */
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }

    /**
     * Solution to roman to integer problem.
     *
     * @param roman - roman numeral.
     * @return int - integer representation of roman number.
     */
    private static int romanToInt(final String roman) {
        int number = 0;
        int position = 0;

        while (position < roman.length()) {
            char currentChar = roman.charAt(position);

            switch (currentChar) {
                case 'I': {
                    if (position != roman.length() - 1) {
                        char next = roman.charAt(position + 1);

                        if (next == 'X') {
                            number += 9;
                            position += 2;
                            continue;
                        }
                        if (next == 'V') {
                            number += 4;
                            position += 2;
                            continue;
                        }
                    }
                    number += 1;
                    break;
                }
                case 'X': {
                    if (position != roman.length() - 1) {
                        char next = roman.charAt(position + 1);

                        if (next == 'L') {
                            number += 40;
                            position += 2;
                            continue;
                        }
                        if (next == 'C') {
                            number += 90;
                            position += 2;
                            continue;
                        }
                    }
                    number += 10;
                    break;
                }
                case 'C': {
                    if (position != roman.length() - 1) {
                        char next = roman.charAt(position + 1);

                        if (next == 'D') {
                            number += 400;
                            position += 2;
                            continue;
                        }
                        if (next == 'M') {
                            number += 900;
                            position += 2;
                            continue;
                        }
                    }
                    number += 100;
                    break;
                }
                case 'V': {
                    number += 5;
                    break;
                }
                case 'L': {
                    number += 50;
                    break;
                }
                case 'D': {
                    number += 500;
                    break;
                }
                case 'M': {
                    number += 1000;
                    break;
                }
            }
            position += 1;
        }
        return number;
    }
}
