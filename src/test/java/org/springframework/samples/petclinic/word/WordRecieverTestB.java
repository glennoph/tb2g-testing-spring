package org.springframework.samples.petclinic.word;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

// junit4
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BaseConfig.class, WordBConfig.class})
public class WordRecieverTestB {

    @Autowired
    WordReciever wordReciever;

    @Test
    public void getWord() {
        String word = wordReciever.getWord();
        assertEquals("word B", word);
    }


}
