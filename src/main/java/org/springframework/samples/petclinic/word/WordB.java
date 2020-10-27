package org.springframework.samples.petclinic.word;

import org.springframework.stereotype.Component;

@Component
public class WordB implements WordProducer {
    @Override
    public String getWord() {
        return "word B";
    }
}
