import java.util.Iterator;

public class Problem2 {
    static class PrimeIterator implements Iterator<Integer> {

        private int limit;
        private int count = 1;

        public PrimeIterator(int limit) {
            this.limit = limit;
        }

        public boolean isPrime(int n) {
            for(int i = 2; i < n; i++) {
                if(n % i == 0) {
                    return false;
                }
            }

            return true;
        }

        @Override
        public boolean hasNext() {
            count++;

            while (true) {
                if (isPrime(count)) {
                    break;
                }

                count++;
            }

            if (count >= limit) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public Integer next() {
            return count;
        }
    }

    public static void main(String[] args) {
        Iterator<Integer> iterator = new Problem2.PrimeIterator(100000);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
