package org.test;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        Parser parser = new Parser();

        List<String> strings = parser.readLinesFromFile("C:\\IdeaProjects\\TestTask\\src\\main\\resources\\input.txt");

        for (String line : strings){
            System.out.println(line);
        }

        List<Line> lines = parser.parseLinesFromStingList(strings);

        for (Line line : lines){
            System.out.println(line);
        }

        Analyzer analyzer = new Analyzer();

        System.out.println(analyzer.analyzeLines(lines).toString());

    }
}