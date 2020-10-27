package org.springframework.samples.petclinic.word;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WordAConfig {

    @Bean
    WordA wordA() {
        return new WordA();
    }
}
