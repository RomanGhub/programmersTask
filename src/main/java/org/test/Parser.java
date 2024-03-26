package org.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final String DELIMITER = "\\.";
    private static final String STAR = "*";
    private static final String QUERY_OR_WAITING_REGEX = "[CD]";
    private static final String FIRST_OR_NEXT_REGEX = "[FN]";
//    private static final Pattern VALID_PATTERN = Pattern.compile("^(" + QUERY_OR_WAITING_REGEX + "\\d+" + DELIMITER + ")+(" + FIRST_OR_NEXT_REGEX + ")$");

    private static final Pattern PATTERN = Pattern.compile(
            "^([CD])" +                         // Query or Waiting timeline (C/D)
            "\\s+" +
            "(\\d+(?:\\.\\d+)?)?" +             // Service ID (optional variation)
            "\\s+" +
            "(\\d+(?:\\.\\d+(?:\\.\\d+)?)?)?" + // Question type ID (optional category and sub-category)
            "\\s+" +
            "([PN])" +                          // Response type (P/N)
            "\\s+" +
            "(\\d{2}\\.\\d{2}\\.\\d{4})" +      // Date (DD.MM.YYYY)
            "\\s+" +
            "?(\\d+)"                     // Optional time in minutes
    );

//    ^([CD])\s+(\d+(?:\.\d+)?)?\s+(\d+(?:\.\d+(?:\.\d+)?)?)?\s+([PN])\s+(\d{2}\.\d{2}\.\d{4})\s+?(\d+)


    public List<String> readLinesFromFile(String fileName) {
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public List<Line> parseLinesFromStingList(List<String> strings) throws Exception {
        List<Line> lines = new ArrayList<>();

        for (String string : strings) {

            Matcher matcher = PATTERN.matcher(string);

//            if (isValidInput(string)) {
            if (matcher.matches()) {
                String queryOrWaiting = matcher.group(1);
                String serviceId = matcher.group(2);
                String questionTypeId = matcher.group(3);
                String responseType = matcher.group(4);
                String date = matcher.group(5);
                String time = matcher.group(6);



                Line line = new Line( new LineType(queryOrWaiting), new Service(serviceId), new Question(questionTypeId),
                        new ResponseType(responseType), new Date(date));
            } else {
                System.out.println("Invalid input format.");
            }
        }

        return lines;
    }

/*    public boolean isValidInput(String input) {
        Matcher matcher = PATTERN.matcher(input);
        return matcher.matches();
    }*/

}
