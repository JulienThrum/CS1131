public class Multiply {
    public int multiply(int a, int b) {
        if(b == 1) {
            return a;
        }

        if(b < 0) {
            return multiply(a, -b) * -1;
        }

        return a + multiply(a, --b);
    }
}
