package org.unbabel.translation.service;

import org.unbabel.translation.entities.AverageTranslation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filter {

    public final List<AverageTranslation> filterOutWindowEvent(Stream<AverageTranslation> translationStream,
                                                               LocalDateTime startTime, int windowSize) {
        return translationStream
                .dropWhile(a -> a.getLocalDateTime().equals(startTime))
                .limit(windowSize)
                .collect(Collectors.toList());
    }
}