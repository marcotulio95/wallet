package br.com.marcotulio.wallet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HelloWorld {

    @Test
    public void testHelloWorld(){
        assertEquals(1,1);
    }
}
