package com.thingstocode.unittesting.examples.example1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class MathTest {

    @Test
    public void shouldAdd() {
        //arrange
        Math math = new Math();

        //act
        int result = math.add(3, 5);

        //assert
        assertEquals(8, result);
    }
}