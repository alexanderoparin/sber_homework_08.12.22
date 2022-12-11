package ru.oparin.reversed_strings;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Homework implements StringReverse {

    @Override
    public String reverse1(String str) {
        if (str == null || str.length() == 0) return str;
        StringBuilder word = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char symbol = str.charAt(i);
            if (Character.isLetter(symbol)) word.append(symbol);
            else {
                result.append(word.reverse()).append(symbol);
                word.setLength(0);
            }
        }
        return result.toString();
    }

    @Override
    public String reverse2(String str) {
        if (str == null || str.length() == 0) return str;
        StringBuilder result = new StringBuilder();
        String[] split = str.split(" ");
        for (String s : split) {
            ArrayDeque<Character> deque = new ArrayDeque<>();
            for (int j = 0; j < s.length(); j++) {
                char symbol = s.charAt(j);
                if (!Character.isAlphabetic(symbol)) {
                    while (!deque.isEmpty()) result.append(deque.pop());
                    result.append(symbol);
                } else deque.push(symbol);
                while (j == s.length() - 1 && !deque.isEmpty()) {
                    result.append(deque.pop());
                }
            }
            result.append(" ");
        }
        return result.toString().trim();
    }

    @Override
    public String reverse3(String str) {
        if (str == null || str.length() == 0) return str;
        String[] split = str.split("\\s+");
        StringBuilder word = new StringBuilder();
        StringBuilder result = new StringBuilder();
        return Arrays.stream(split)
                .map(String::toCharArray)
                .map(chars -> {
                    IntStream.range(0, chars.length)
                            .forEach(i -> {
                                if (Character.isLetter(chars[i]))
                                    word.append(chars[i]);
                                else {
                                    result.append(word.reverse());
                                    result.append(chars[i]);
                                    word.setLength(0);
                                }
                                if (i == chars.length - 1) {
                                    result.append(word.reverse());
                                    word.setLength(0);
                                }
                            });
                    String string = result.toString();
                    result.setLength(0);
                    return string;
                })
                .collect(Collectors.joining(" "));
    }
}
