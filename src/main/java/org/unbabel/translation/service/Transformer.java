package org.unbabel.translation.service;

import org.unbabel.translation.entities.AverageTranslation;
import org.unbabel.translation.entities.TranslationEntity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Transformer {

    public final Stream<AverageTranslation> averageMetrics(Map<LocalDateTime, List<Long>> groupedEntities) {
        return groupedEntities.entrySet()
                .stream()
                .map(e -> new AverageTranslation(e.getKey(),
                        e.getValue().stream().mapToLong(i -> i).average().orElse(Double.MIN_VALUE)))
                .sorted(Comparator.comparing(AverageTranslation::getLocalDateTime)); // sorted by time

    }


    // {"timestamp": "2018-12-26 18:11:08.509654","translation_id": "5aa5b2f39f7254a75aa5","source_language": "en","target_language": "fr","client_name": "easyjet","event_name": "translation_delivered","nr_words": 30, "duration": 20}
    // {"timestamp": "2018-12-26 18:15:19.903159","translation_id": "5aa5b2f39f7254a75aa4","source_language": "en","target_language": "fr","client_name": "easyjet","event_name": "translation_delivered","nr_words": 30, "duration": 31}
    // {"timestamp": "2018-12-26 18:23:19.903159","translation_id": "5aa5b2f39f7254a75bb33","source_language": "en","target_language": "fr","client_name": "booking","event_name": "translation_delivered","nr_words": 100, "duration": 54}
    // TODO :: think of localdatetime in window which are not involved as key. e.g. 18:14:00 in above sample
    public final Map<LocalDateTime, List<Long>> groupEntityByTime(Stream<TranslationEntity> translationEntityStream) {
        return translationEntityStream
                .collect(Collectors.groupingBy(a -> convertLocalDateTimeToMinutes(a.getTimestamp()),
                        Collectors.mapping(TranslationEntity::getDuration, Collectors.toList())));
    }

    // Perform a ceil such as this would convert 18:15:19.903159 to 18:16:00
    private static LocalDateTime convertLocalDateTimeToMinutes(LocalDateTime source) {
        return source.plus(20, ChronoUnit.SECONDS); // TODO :: not a real logic
    }
}