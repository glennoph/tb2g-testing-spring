package org.springframework.samples.petclinic.word;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


import static org.junit.Assert.*;

// junit5
@SpringJUnitConfig(classes = {BaseConfig.class, WordBConfig.class})
public class WordRecieverTestB {

    @Autowired
    WordReciever wordReciever;

    @Test
    public void getWord() {
        String word = wordReciever.getWord();
        assertEquals("word B", word);
    }


}
