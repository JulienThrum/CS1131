import java.util.Arrays;

/**
 * CLASS DESCRIPTION COMMENT
 */
public class Prog3Cipher {
    // INSTANCE VARIABLES
    char[] keyList; // VARIABLE DESCRIPTION COMMENT
    char[][] cipherTable; // VARIABLE DESCRIPTION COMMENT

    // METHODS

    /**
     * METHOD DESCRIPTION COMMENT
     *
     * @param message
     * @return
     */
    String encode(String message) {
        String result = "";
        int keyListCounter = 0;
        message = message.toUpperCase();
        char[] messageChar = message.toCharArray();
        //A = 65
        for(int i = 0; i < message.length(); i++) {
            if(messageChar[i] >= 'A' && messageChar[i] <= 'Z') {
                int row = (int) this.keyList[keyListCounter] - 'A';
                int column = (int) messageChar[i] - 'A';
                result += this.cipherTable[row][column];
            } else {
                result += messageChar[i];
            }
            if(keyListCounter == this.keyList.length - 1) {
                keyListCounter = 0;
            } else {
                keyListCounter++;
            }
        }
        System.out.println(result);
        return result;
    }

    /**
     * METHOD DESCRIPTION COMMENT
     *
     * @param message
     * @return
     */
    String decode(String message) {
        String result = "";
        int keyListCounter = 0;
        char[] messageChar = message.toCharArray();

        for(int i = 0; i < message.length(); i++) {
            int row = (int) this.keyList[keyListCounter] - 'A';
            if(messageChar[i] >= 'A' && messageChar[i] <= 'Z') {
                for(int j = 0; j < 26; j++) {
                    if((int) this.keyList[keyListCounter] - 'A' == j) {
                        for(int k = 0; k < 26; k++) {
                            if(messageChar[i] == cipherTable[row][k]) {
                                result += (char)(k + 'A');
                            }
                        }
                    }
                }
            } else {
                result += messageChar[i];
            }
            if(keyListCounter == this.keyList.length - 1) {
                keyListCounter = 0;
            } else {
                keyListCounter++;
            }
        }
        System.out.println(result);
        return result;
    }

    // CONSTRUCTORS

    /**
     * CONSTRUCTOR DESCRIPTION COMMENT
     *
     * @param code
     * @param key
     */
    public Prog3Cipher(char code, String key) {
        //create the cipherTable and remove spaces from key while turning it into a char array
        int letterCounter = 0;

        int letterStarter = 0;
        this.cipherTable = new char[26][26];
        this.keyList = key.replaceAll(" ", "").toCharArray();
        for(int row = 0; row < 26; row++) {
            for(int column = 0; column < 26; column++) {
                if((int) code + letterCounter + letterStarter > 'Z') {
                    if((int) code + letterCounter + letterStarter > 'Z' + 26) {
                        this.cipherTable[row][column] = (char) ((int) code + letterCounter + letterStarter - 52);
                    } else {
                        this.cipherTable[row][column] = (char) ((int) code + letterCounter + letterStarter - 26);
                    }
                } else {
                    this.cipherTable[row][column] = (char) ((int) code + letterCounter + letterStarter);
                }

                letterCounter++;
            }

            letterCounter = 0;
            letterStarter++;
        }
    }

    // MAIN (TEST) Method

    /**
     * METHOD DESCRIPTION COMMENT
     *
     * @param args
     */
    public static void main(String[] args) {
        // Testing only works if using VM argument -ea
        Prog3Cipher self = new Prog3Cipher('H', "BABBAGE");

        assert "PHXXF MQYBPKNJ".equals(self.encode("Happy Birthday"));
        assert "HAPPY BIRTHDAY".equals(self.decode("PHXXF MQYBPKNJ"));
    }
} // END OF CLASS --------------------------------------------------------