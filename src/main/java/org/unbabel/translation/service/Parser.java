package org.unbabel.translation.service;

import org.unbabel.translation.entities.TranslationEntity;

import java.util.stream.Stream;

public class Parser {

    public Stream<TranslationEntity> deliveryTranslationStream(String inputFile) {
        return Stream.of(new TranslationEntity()); // TODO :: perform JSON object mapping reading the file
    }
}