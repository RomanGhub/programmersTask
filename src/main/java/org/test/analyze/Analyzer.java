package org.test.analyze;

import org.test.entity.Line;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Analyzer {

    public List<Integer> analyzeLines(List<Line> lines) {
        List<Integer> results = new ArrayList<>();

        List<Line> linesForAnalyzing = new ArrayList<>();

        for (Line line : lines) {
            if (Objects.equals(line.getLineType().getTypeAsString(), "C")) {
                linesForAnalyzing.add(line);
            } else if (Objects.equals(line.getLineType().getTypeAsString(), "D")) {
                results.add(BigDecimal.valueOf(
                                linesForAnalyzing.stream()
                                        .filter(waitingLine -> isValidForAnalyzing(line, waitingLine))
                                        .map(Line::getTimeInMinutes)
                                        .mapToInt(Integer::intValue)
                                        .average().orElse(0.0))
                        .setScale(2, RoundingMode.HALF_EVEN).intValueExact());

            } else {
                throw new IllegalArgumentException("Line is not query nor a waiting line");
            }
        }

        return results;
    }

    public Boolean isValidForAnalyzing(Line query, Line line) {
        List<LocalDate> datesPeriod = query.getDate().getTimePeriod();
        LocalDate date = line.getDate().getDate();

        return (date.isAfter(datesPeriod.get(0)) || date.isEqual(datesPeriod.get(0)))
                && (date.isBefore(datesPeriod.get(1)) || date.isEqual(datesPeriod.get(1)))
                && query.isValid(line);
    }

}
