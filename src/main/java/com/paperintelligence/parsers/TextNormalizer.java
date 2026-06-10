package com.paperintelligence.parsers;

import java.util.regex.Pattern;

public class TextNormalizer {

    public static String removeFootMetaData(String text, String start, String end) {
        if (text == null || start == null || end == null) {
            System.out.println("Data transfer error");
            return "";
        }
        String regex = "(?is)" + Pattern.quote(start) + ".*?" + Pattern.quote(end);
        return text.replaceAll(regex, "").trim();

    }

}
