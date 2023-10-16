package week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GugusemTest {

    @Test
    void multiply() {
        Gugusem gugu = new Gugusem();

        assertEquals(gugu.multiply(4,5), 20);
    }

}