package org.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final Pattern PATTERN = Pattern.compile(
            "^([CD])" +                             // Query or Waiting timeline (C/D)
            "\\s+" +
            "(\\d+(?:\\.\\d+)?|\\*)?" +             // Service ID (optional variation)
            "\\s+" +
            "(\\d+(?:\\.\\d+(?:\\.\\d+)?)?|\\*)?" + // Question type ID (optional category and sub-category)
            "\\s+" +
            "([PN])" +                              // Response type (P/N)
            "\\s+" +
            "(\\d{2}\\.\\d{2}\\.\\d{4}" +           // Date (DD.MM.YYYY) OR
            "(?:-\\d{2}.\\d{2}.\\d{4})?)" +         // Date (DD.MM.YYYY-DD.MM.YYYY)  //previous
            "\\s?(\\d+)?"                           // Optional time in minutes

    );

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

            if (matcher.matches()) {
                String queryOrWaiting = matcher.group(1);
                String serviceId = matcher.group(2);
                String questionTypeId = matcher.group(3);
                String responseType = matcher.group(4);
                String date = matcher.group(5);
                String time = matcher.group(6);

                Line line = new Line( new LineType(queryOrWaiting), new Service(serviceId), new Question(questionTypeId),
                        new ResponseType(responseType), new Date(date), time);

                lines.add(line);
            } else {
                System.out.println("Invalid input format");
            }
        }

        return lines;
    }

}
