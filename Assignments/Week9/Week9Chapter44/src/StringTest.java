import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class StringTest {
    private static String s = "Hello";

    @Test
    public void length() {
        Assert.assertEquals(s.length(), 5);
    }

    @Test
    public void charAt() {
        Assert.assertEquals(s.charAt(3), 'l');
    }

    @Test
    public void substring() {
        Assert.assertEquals(s.substring(2), "llo");
        Assert.assertEquals(s.substring(1, 4), "ell");
    }

    @Test
    public void indexOf() {
        Assert.assertEquals(s.indexOf('e'),1);
    }
}
