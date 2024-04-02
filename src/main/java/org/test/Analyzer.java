package org.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class Analyzer {


    public List<Integer> analyzeLines(List<Line> lines) {

        List<Integer> results = new ArrayList<>();

//        Stack<Line> lineStack = new Stack<>();
        List<Line> lineStack = new ArrayList<>();

        for (Line line: lines){
            // dont forget to change to equals
            if (Objects.equals(line.getLineType().getTypeAsString(), "C")) {  //TODO
//                lineStack.push(line);
                lineStack.add(line);
            } else if (Objects.equals(line.getLineType().getTypeAsString(), "D")) {
                results.add(((Double) lineStack.stream().filter(waitingLine -> isValidForAnalyzing(line, waitingLine)).
                        collect(Collectors.summarizingInt(Line::getTimeInMinutes)).getAverage()).intValue());
//                lineStack.removeAll(lineStack);
            } else {
                throw new RuntimeException("Nor query nor waiting line");
            }

        }

        return results;
    }

    public Boolean isValidForAnalyzing(Line query, Line line){
        List<LocalDate> datesPeriod = query.getDate().getTimePeriod();
        LocalDate date = line.getDate().getDate();

       return (date.isAfter(datesPeriod.get(0)) || date.isEqual(datesPeriod.get(0)))
               && (date.isBefore(datesPeriod.get(1)) || date.isEqual(datesPeriod.get(1)))
               && query.isValid(line);
    }

}
