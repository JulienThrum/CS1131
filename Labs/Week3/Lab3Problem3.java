public class Lab3Problem3 {

    public static void main(String[] args){

        String[] words = {"I", "Love", "Javas"};

        String[] moreWords = {"Millions", "of", "peaches", "for", "me."};

        for (int i = 0; i < words.length; i++) {

            moreWords[i] = words[i];
        }

        System.out.println(String.join(" ", words));

        System.out.println(String.join(" ", moreWords));

    }
}
