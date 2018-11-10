import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplyTest {

    @Test
    public void multiply() {
        Multiply obj = new Multiply();
        Assert.assertEquals(0, obj.multiply(5,0));
    }
}