package org.unbabel.translation;

import org.unbabel.translation.entities.AverageTranslation;
import org.unbabel.translation.entities.TranslationEntity;
import org.unbabel.translation.service.Filter;
import org.unbabel.translation.service.Parser;
import org.unbabel.translation.service.Transformer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Meter {
    private static Parser parser;
    private static Transformer transformer;
    private static Filter filter;

    public Meter(Parser parser, Transformer transformer, Filter filter) {
        Meter.parser = parser;
        Meter.transformer = transformer;
        Meter.filter = filter;
    }

    public static void main(String[] args) {
        validateRequest(args);
        System.out.println("Starting...");
        String filePath = args[0];
        int windowSize = Integer.parseInt(args[1]);
        Stream<TranslationEntity> translationEntityStream = parser.deliveryTranslationStream(filePath);
        Map<LocalDateTime, List<Long>> durationsGroupedByTime = transformer.groupEntityByTime(translationEntityStream);
        Stream<AverageTranslation> averageTranslationStream = transformer.averageMetrics(durationsGroupedByTime);
        List<AverageTranslation> windowMetrics = filter.filterOutWindowEvent(averageTranslationStream, LocalDateTime.now(), windowSize);
        System.out.println("Completed!!");
    }

    private static void validateRequest(String... args) {
        if (args.length != 2) {
            System.out.println("Usage : unbabel_cli --input_file events.json --window_size 10");
            System.exit(1);
        }
    }
}