import org.junit.Test;

import static org.junit.Assert.*;

public class PowTest {

    @Test
    public void pow() {
        Pow obj = new Pow();
        assertEquals(1/16.0, obj.pow(-4,-2), 1E-14);
    }
}