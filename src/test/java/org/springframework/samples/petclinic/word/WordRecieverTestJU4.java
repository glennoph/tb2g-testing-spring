package org.springframework.samples.petclinic.word;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


// junit4
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BaseConfig.class, WordAConfig.class})
public class WordRecieverTestJU4 {
    @Autowired
    WordReciever wordReciever;

//    @Before
//    public void setUp() throws Exception {
//        System.out.println("WordRecieverTest");
//        wordReciever = new WordReciever(new WordA());
//    }

    @Test
    public void getWord() {
        String word = wordReciever.getWord();
        assertEquals("word A", word);
    }
}