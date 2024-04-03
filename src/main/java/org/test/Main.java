package org.test;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        Parser parser = new Parser();
        //TODO: change path
        List<String> strings = parser.readLinesFromFile(".\\src\\main\\resources\\input.txt");

        //TODO: explain what is this
        for (String line : strings){
            System.out.println(line);
        }

        //TODO check exception
        List<Line> lines = parser.parseLinesFromStingList(strings);

        for (Line line : lines){
            System.out.println(line);
        }

        Analyzer analyzer = new Analyzer();

        System.out.println(analyzer.analyzeLines(lines).toString());

    }
}