package org.springframework.samples.petclinic.word;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfig {

    @Bean
    WordReciever wordReciever(WordProducer wordProducer) {
        return new WordReciever(wordProducer);
    }
}
