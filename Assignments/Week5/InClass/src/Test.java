import java.util.ArrayList;
public class Test {

    public class KeyValuePair {
        public String key;
        public int value;

        public KeyValuePair(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void listStuff() {
        ArrayList<KeyValuePair> list = new ArrayList<KeyValuePair>();
        list.add(new KeyValuePair("Bob", 42));
        list.add(new KeyValuePair("Carol", 26));
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.listStuff();
    }
}
