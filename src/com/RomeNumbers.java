package com;


public class RomeNumbers {
    int[] numbers = {100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] letters = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    String roms = "I_II_III_IV_V_VI_VII_VIII_IX_X";
    public int arabic = 0;

    public RomeNumbers() {

    }

    public RomeNumbers(String roman) {
        roman = roman.toUpperCase();
        int i = 0;

        if (!roms.contains(roman)) {
            throw new IllegalArgumentException("Data entry error.");
        }

        while (i < roman.length()) {
            char letter = roman.charAt(i);
            int number = letterToNumber(letter);

            if (number < 0)
                throw new NumberFormatException("Data entry error.");

            i++;

            if (i == roman.length()) {
                arabic += number;
            } else {
                int nextNumber = letterToNumber(roman.charAt(i));

                if (nextNumber > number) {
                    arabic = arabic + (nextNumber - number);
                    i++;
                } else {
                    arabic += number;
                }
            }
        }

        if (arabic > 10){
            throw new IllegalArgumentException("Data entry error. Number > 10");
        }
    }

    private int letterToNumber (char letter) {
        switch (letter) {
            case 'I':
                return 1;
                case 'V':
                    return 5;
                    case 'X':
                        return 10;
                        case 'L':
                            return 50;
                            case 'C':
                                return 100;
                                default:
                                    return -1;
        }
    }

    public String ToRoman() {         // метод перевода в римскую число
        if (arabic < 1){
            throw new IllegalArgumentException("Data entry error.");
        }

        String roman = "";

        for (int i = 0; i < numbers.length; i++) {

            while (arabic >= numbers[i]){
                roman += letters[i];
                arabic -= numbers[i];
            }

        }
        return roman;
    }
}