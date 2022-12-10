package ru.oparin.reversed_strings;

public interface StringReverse {
    /**
     * Преобразует строку:
     *  - все слова меняют направление
     *  - вся пунктуация остается на месте
     *
     * @param str исходная строка
     * @return результат преобразования
     */
    String reverse1(String str);
    String reverse2(String str);
    String reverse3(String str);
}
