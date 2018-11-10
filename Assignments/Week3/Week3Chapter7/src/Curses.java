import java.util.Random;

/* *
 * Generate a curse in the form :
 * May <noun > <verb > your <object >!
 *
 * @authors Julien Thrum
 */
public class Curses {
    String[] nouns = {"a cat", "a slimy sluggish slug", "a pterodactyl with a big beak", "your gray haired momma", "the world's fastest turtle", "your neighbor's large grey dog"};
    String[] verbs = {"step on", "eat", "destroy with its big toes", "gently crush with the help of a giant", "light on fire with a flamethrower"};
    String[] objects = {"homework", "brand new kite", "bath towel", "most prized possessions", "dormitory"};

    /*
        Randomly choose an index from the given list.
     */
    public String getRandomElement(String[] list) {
        return list[(int)(Math.random() * (list.length))];
    }

    /* *
     * Generate the curse using the following pattern :
     * " May %s %s your %s !"
     */
    public String generateCurse() {
        return String.format("May %s %s your %s!", getRandomElement(nouns), getRandomElement(verbs), getRandomElement(objects));
    }

    // Test your code . As implemented , main prints 10 curses .
    public static void main(String[] args) {
        Curses thing = new Curses();
        for (int i = 0; i < 10; i++) {
            System.out.println(thing.generateCurse());
        }
    }
}