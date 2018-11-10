/*
@author Julien Thrum
 */
public class Main {
    public static void main(String[] args) {
        int n = 0;
        while (Math.pow(n, 2) < 12000) {
            n++;
        }
        System.out.println("Largest value of n such that n^2 < 12,000 is " + (n - 1));
    }
}