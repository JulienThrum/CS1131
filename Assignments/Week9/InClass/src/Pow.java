public class Pow {
    public double pow(double b, int e) {
        if(e == 1) {
            return b;
        }

        if(e < 0) {
            return 1 / pow(b, -e);
        }

        return b * pow(b, --e);
    }
}
