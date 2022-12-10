package ru.oparin.reversed_strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HomeworkTest {

    @Test
    public void shouldReverseWordsInString() {
        String sourse = "Any string(\"char,word sequence \"), whith punctuation!";
        String result = "ynA gnirts(\"rahc,drow ecneuqes \"), htihw noitautcnup!";
        Homework homework = new Homework();
        assertEquals(result, homework.reverse1(sourse));
        assertEquals(result, homework.reverse2(sourse));
        assertEquals(result, homework.reverse3(sourse));
    }
}
