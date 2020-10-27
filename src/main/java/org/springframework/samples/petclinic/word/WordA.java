package org.springframework.samples.petclinic.word;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class WordA implements WordProducer {
    @Override
    public String getWord() {
        return "word A";
    }
}
