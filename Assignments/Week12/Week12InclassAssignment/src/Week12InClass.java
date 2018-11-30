import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Week12InClass implements Iterable {
    private final String KEY = "flippertygibbet";
    private final String TRANSFORMATION = "AES";
    private final String ALGORITHM = "SHA-1";

    private HashMap<String, String> pwds = new HashMap<String, String>();
    private HashMap<String, String> salts = new HashMap<String, String>();

    /**
     * Create a new password
     * Validates password has 1 uppercase, 1 lowercase, 1 symbol, 1 number, at least 12 characters
     *
     * @param userid
     * @param password
     */
    public void createPassword(String userid, String password) {
        if(validPassword(password)) {
            salts.put(userid, generateSalt());
            pwds.put(userid, encrypt(password, salts.get(userid)));
        } else {
            System.out.println("Invalid password");
        }
    }

    /**
     * change password
     * old password must match
     * Validates new password has 1 uppercase, 1 lowercase, 1 symbol, 1 number, at least 12 characters
     *
     * @param userid
     * @param oldPassword
     * @param newPassword
     */
    public void changePassword(String userid, String oldPassword, String newPassword) {
        if(validPassword(newPassword)) {
            if(oldPassword.equals(pwds.get(userid))) {
                pwds.put(userid, encrypt(newPassword, salts.get(userid)));
            }
        } else {
            System.out.println("Invalid password");
        }
    }

    /**
     * Retrieves the password
     *
     * @param userid
     * @return userid's unencrypted password
     */
    private String retrievePassword(String userid) {
        return decrypt(pwds.get(userid), salts.get(userid));
    }

    /**
     * Iterates through the a list of encrypted password, salt combinations
     * (Does not iterate through unencrypted passwords)
     *
     * @return Iterator of a list of String arrays of the passwords and salts
     */
    public Iterator iterator() {
        String[] pair = new String[2];
        ArrayList<String[]> pwdsSaltList = new ArrayList<>();

        for(String s : pwds.keySet()) {
            pair[0] = pwds.get(s);
            pair[1] = salts.get(s);
            pwdsSaltList.add(pair);
        }

        return pwdsSaltList.iterator();
    }

    private String generateSalt() {
        return Long.toString(System.currentTimeMillis());
    }

    private String encrypt(String plaintext, String salt) {
        if(plaintext == null || plaintext.isEmpty()) {
            throw new IllegalArgumentException("Bad Input");
        }
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);

            byte[] key = (salt + KEY).getBytes("UTF-8");
            MessageDigest sha = MessageDigest.getInstance(ALGORITHM);
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); // use only first 128 bit

            SecretKeySpec secretKeySpec = new SecretKeySpec(key, TRANSFORMATION);

            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte[] inputBytes = plaintext.getBytes();
            byte[] outputBytes = cipher.doFinal(inputBytes);

            return Base64.getEncoder().encodeToString(outputBytes);
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch(InvalidKeyException e) {
            e.printStackTrace();
        } catch(NoSuchPaddingException e) {
            e.printStackTrace();
        } catch(BadPaddingException e) {
            e.printStackTrace();
        } catch(IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch(UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String decrypt(String encryptedText, String salt) {
        if(encryptedText == null || encryptedText.isEmpty()) {
            throw new IllegalArgumentException("Bad Input");
        }
        try {
            Cipher c = Cipher.getInstance(TRANSFORMATION);
            byte[] keyBytes = Arrays.copyOf(MessageDigest.getInstance(ALGORITHM).digest((salt + KEY).getBytes("UTF-8")), 16);
            c.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keyBytes, TRANSFORMATION));
            return new String(c.doFinal(Base64.getDecoder().decode(encryptedText)));
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch(InvalidKeyException e) {
            e.printStackTrace();
        } catch(NoSuchPaddingException e) {
            e.printStackTrace();
        } catch(BadPaddingException e) {
            e.printStackTrace();
        } catch(IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch(UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean validPassword(String password) {
        boolean length = false;
        boolean symbol = false;
        boolean uppercase = false;
        boolean lowercase = false;
        boolean number = false;

        //check to see if valid
        if(password.length() > 11) {
            length = true;
        }

        for(char c : password.toCharArray()) {
            if((int) c > 47 && (int) c < 58) {
                number = true;
            }

            if((int) c > 64 && (int) c < 91) {
                uppercase = true;
            }

            if((int) c > 96 && (int) c < 123) {
                lowercase = true;
            }

            if(((int) c > 31 && (int) c < 48) ||
                    ((int) c > 57 && (int) c < 65) ||
                    ((int) c > 90 && (int) c < 97) ||
                    ((int) c > 122 && (int) c < 127)) {
                symbol = true;
            }
        }

        return (length && symbol && lowercase && uppercase && number);
    }

    public static void main(String[] args) {
        Week12InClass foo = new Week12InClass();
        foo.createPassword("CS1131", "@1aBqwertyui");
        foo.createPassword("Julien", "!1eAbfhdaAKJHDGdbhajskd");
        System.out.println(foo.retrievePassword("CS1131"));
        System.out.println(foo.pwds);
        foo.changePassword("CS1131", "@1aBqwertyui", "#89AShuisaOGSAguyo");
        System.out.println(foo.retrievePassword("CS1131"));
        System.out.println(foo.pwds);
        System.out.println(foo.salts);
    }
}
