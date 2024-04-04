package org.test.parse;

import org.test.entity.*;

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
            "(\\d{2}\\.\\d{2}\\.\\d{4}" +           // Date (DD.MM.YYYY) OR              (depending on input conventions, it could be both d{2} or d{1,2}. Clarification needed.)
            "(?:-\\d{2}.\\d{2}.\\d{4})?)" +         // Date (DD.MM.YYYY-DD.MM.YYYY)
            "\\s?(\\d+)?"                           // Optional time in minutes

    );

    public List<String> readLinesFromFile(String fileName) {
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (lines.size() - 1 == Integer.parseInt(lines.get(0))) {
            lines.remove(0);
        } else {
            throw new IllegalArgumentException("Count differs from actual number of lines");
        }

        return lines;
    }

    public List<Line> parseLinesFromStingList(List<String> strings){
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

                Line line = new Line(new LineType(queryOrWaiting), new Service(serviceId), new Question(questionTypeId),
                        new ResponseType(responseType), new Date(date), time);

                lines.add(line);
            } else {
                System.out.println("Invalid input format");
            }
        }

        return lines;
    }

}
