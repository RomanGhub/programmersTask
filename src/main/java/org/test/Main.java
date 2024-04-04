package org.test;

import org.test.analyze.Analyzer;
import org.test.entity.Line;
import org.test.parse.Parser;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Parser parser = new Parser();
        Analyzer analyzer = new Analyzer();

        URL resource = Main.class.getClassLoader().getResource("input.txt");

        String path = null;
        try {
            path = Paths.get(resource.toURI()).toFile().getAbsolutePath();
        } catch (NullPointerException | URISyntaxException e) {
            System.err.println("No such file or bad syntax");
        }

        List<String> strings = parser.readLinesFromFile(path);

        /* Print strings that were parsed from
           input file to ensure correct work of parser */
        for (String line : strings) {
            System.out.println(line);
        }

        List<Line> lines = parser.parseLinesFromStingList(strings);

        /* Print Lines that were created from
           strings to ensure their correctness */
        for (Line line : lines) {
            System.out.println(line);
        }

//        System.out.println(analyzer.analyzeLines(lines).toString());

        List<Integer> results = analyzer.analyzeLines(lines);

        for (Integer result : results) {
            if (result != null && !result.equals(0)) {
                System.out.println(result);
            } else {
                System.out.println("-");
            }
        }

    }
}