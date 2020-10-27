package org.springframework.samples.petclinic.word;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WordBConfig {

    @Bean
    WordB wordB() {
        return new WordB();
    }

}
