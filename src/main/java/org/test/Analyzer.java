package org.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Analyzer {


    public List<Double> analyzeLines(List<Line> lines) {
        //TODO make it Double
        List<Double> results = new ArrayList<>();

        List<Line> linesForAnalyzing = new ArrayList<>();

        for (Line line: lines){
            if (Objects.equals(line.getLineType().getTypeAsString(), "C")) {
                linesForAnalyzing.add(line);
            } else if (Objects.equals(line.getLineType().getTypeAsString(), "D")) {
                results.add((
                    linesForAnalyzing.stream()
                    .filter(waitingLine -> isValidForAnalyzing(line, waitingLine))
                        .map(Line::getTimeInMinutes)
                        .mapToInt(Integer::intValue)
                        .average().orElse(0.0)));
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
