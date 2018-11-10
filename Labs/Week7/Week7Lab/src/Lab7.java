/**
 * A collection of methods which each have some flaw for you to correct.
 *
 * @author <Your Name!>
 */

public class Lab7 {

    /**
     * Calculates the minimum value of an array. If the array is empty, returns
     * Integer.MAX_VALUE.
     *
     * @param array the array of ints in which to find the minimum
     * @return the minimum value
     */
    public int min(int[] array) {
        int result = Integer.MAX_VALUE;
        for(int x = 0; x < array.length; x += 1) {
            if(result > array[x]) {
                result = array[x];
            }
        }
        return result;
    }

    /**
     * Calculates the maximum value of an array. If the array is empty, returns
     * Integer.MIN_VALUE.
     *
     * @param array the array of ints in which to find the maximum
     * @return The maximum value
     */
    public int max(int[] array) {
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i += 1) {
            if(result < array[i]) {
                result = array[i];
            }
        }
        return result;
    }

    /**
     * Returns a string representation of the contents of the specified array.
     * The string representation should be of the form "[a0, a1, ..., aN]". Pay
     * close attention to spacing.
     *
     * @param array an array whose string representation to return
     * @return a string representation of the array
     */
    public String toString(int[] array) {
        String ret = "[";

        for(int index = 0; index < array.length; index += 1) {
            ret += array[index];
            if(index == array.length - 1) {
                ret += ("]");
            } else {
                ret += (", ");
            }
        }
        return ret;
    }

    /**
     * Returns true if the two specified arrays of ints are equal to one
     * another. Two arrays are considered equal if both arrays contain the same
     * number of elements, and all corresponding pairs of elements in the two
     * arrays are equal. In other words, two arrays are equal if they contain
     * the same elements in the same order.
     *
     * @param thisArray an array to be tested for equality
     * @param thatArray an array to be tested for equality
     * @return true if the two arrays are equal
     */
    public boolean equals(int[] thisArray, int[] thatArray) {
        boolean same = true;
        for(int index = 0; index < thisArray.length; index += 1) {
            if(thisArray[index] != thatArray[index]) {
                same = false;
            }
        }
        return same;
    }

    /**
     * Sorts an array in ascending order, returning the sorted array. The
     * given array should remain unchanged.
     *
     * @param array array to be sorted
     * @return the sorted array
     */
    public int[] sort(final int[] array) {
        // copy array into a new array to be sorted
        int ret[] = new int[array.length];
        copy(array, ret);

        // start at the far left, and iterate to the right until sorted
        for(int cycle = 0; cycle < ret.length - 1; cycle += 1) {
            /* Bubble the element at cycle + 1 left until either the index
             * reaches zero or the number to the left is smaller.
             */
            for(int index = cycle + 1; (index > 0 && ret[index] < ret[index - 1]); index -= 1) {
                swap(ret, index, index - 1);
            }
        }

        return ret;
    }

    /**
     * Checks whether the given expression has balanced parentheses. Ignore all
     * other characters in the expression.
     *
     * @param expression an expression to check for balanced parentheses
     * @return true if the parenthesis match, false otherwise
     */
    public boolean matched(String expression) {
        int count = 0;
        boolean matched = true;
        // loop through the characters in the expression
        for(char index = 0; index < expression.length(); index += 1) {
            // change the counter based on parenthesis found
            if(expression.substring(index, index + 1).equals("(")) {
                count += 1;
            } else if(expression.substring(index, index + 1).equals(")")){
                count -= 1;
            }
        }

        // if the count is zero, everything matched up
        if(count != 0) {
            matched = false;
        }
        return matched;
    }

    /**
     * Swaps two elements of an array.
     *
     * @param array  array whose elements to swap
     * @param index1 index of the first number in the array
     * @param index2 index of the second number in the array
     */
    private void swap(int[] array, int index1, int index2) {
        final int TEMP = array[index1];
        array[index1] = array[index2];
        array[index2] = TEMP;
    }


    /**
     * Copies the elements from the source array to the destination array.
     *
     * @param source      the source array
     * @param destination the destination array
     */
    private void copy(int[] source, int[] destination) {
        for(int index = 0; index < source.length; index += 1) {
            destination[index] = source[index];
        }
    }

    /**
     * This method contains no bugs. If your program compiles correctly with
     * this method unaltered that means your program has no syntax error.
     * (It may still contain logic errors!)
     * <p>
     * These tests are not thorough. You should supplement with your own tests.
     */
    public static void main(String[] args) {
        Lab7 obj = new Lab7();

        int minimum = obj.min(new int[]{1, 2, 3, -4, 5, 6, 7});
        assert minimum == -4;
        if(minimum != -4) {
            System.out.println("min test failed");
        }

        int maximum = obj.max(new int[]{1, 2, 8, 4, 5, 8, 7});
        assert maximum == 8;
        if(maximum != 8) {
            System.out.println("max test failed");
        }

        String string = obj.toString(new int[]{1, 2, 3, 4, 5, 6, 7});
        assert string.equals("[1, 2, 3, 4, 5, 6, 7]");
        if(!string.equals("[1, 2, 3, 4, 5, 6, 7]")) {
            System.out.println("toString test failed ");
        }

        boolean equals = obj.equals(new int[]{1, 2, 3},
                new int[]{1, 2, 3});
        assert equals == true;
        if(!equals) {
            System.out.println("equals test failed");
        }

        int[] sorted = obj.sort(new int[]{1, 7, 2, 6, 3, 5, 4});
        for(int i = 0; i < 7; i++) {
            assert sorted[i] == i + 1;
            if(sorted[i] != i + 1) {
                System.out.println("sort test failed");
                break;
            }
        }

        boolean matched = obj.matched("( hello . ( world ) ))");
        assert matched == false;
        if(matched) {
            System.out.println("matched test failed");
        }
    }
}