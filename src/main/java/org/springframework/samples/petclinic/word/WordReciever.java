package org.springframework.samples.petclinic.word;

import org.springframework.stereotype.Service;

@Service
public class WordReciever {

    private final WordProducer wordProducer;

    public WordReciever(WordProducer wordProducer) {
        this.wordProducer = wordProducer;
    }

    public String getWord() {
        String word = wordProducer.getWord();
        System.out.println(word);
        return word;
    }
}
