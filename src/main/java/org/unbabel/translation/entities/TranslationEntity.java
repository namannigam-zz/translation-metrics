package org.unbabel.translation.entities;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Locale;

@Getter
public class TranslationEntity {
    String translationId;
    LocalDateTime timestamp;
    Locale sourceLanguage;
    Locale targetLanguage;
    String clientName;
    String eventName;
    Long duration;
    Long wordCount;
}

//    {
//        "timestamp": "2018-12-26 18:12:19.903159",
//        "translation_id": "5aa5b2f39f7254a75aa4",
//        "source_language": "en",
//        "target_language": "fr",
//        "client_name": "easyjet",
//        "event_name": "translation_delivered",
//        "duration": 20,
//        "nr_words": 100
//    }