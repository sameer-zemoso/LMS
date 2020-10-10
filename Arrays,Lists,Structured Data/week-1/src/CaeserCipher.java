
import edu.duke.*;

class CaesarCipher {

    public String encrypt(String input, int key){
        //avoided abcd string
        StringBuilder encrypted = new StringBuilder(input);
        for(int i = 0; i < encrypted.length(); i++) {
            char currentChar = Character.toUpperCase(encrypted.charAt(i));
            currentChar = (char)((int)currentChar + key);
            if (currentChar > 'Z') {
                currentChar = (char)((int)currentChar - (int)'Z' + (int)'A' - 1);
            }
            encrypted.setCharAt(i,currentChar);
        }
        return encrypted.toString();
    }

    public String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        for(int i = 0; i < encrypted.length(); i++) {
            if(i % 2 == 0) {
                String string= encrypt(Character.toString(encrypted.charAt(i)), key1);
                char encryptedChar = string.charAt(0);
                encrypted.setCharAt(i, encryptedChar);
            } else {
                String string = encrypt(Character.toString(encrypted.charAt(i)), key2);
                char encryptedChar = string.charAt(0);
                encrypted.setCharAt(i, encryptedChar);
            }
        }
        return encrypted.toString();
    }

    public void testEncrypt() {
        //System.out.println(encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
        int key = 15;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt("aaaz", key);
        System.out.println("key is " + key + "\n" + encrypted);
    }

    public void testEncryptTwoKeys() {

        int key1 = 1;
        int key2 = 2;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encryptTwoKeys("aaaaa", key1, key2);
        System.out.println("keys are " + key1 + " and " + key2 + "\n" + encrypted);
    }

    public static void main(String[] args) {
        CaesarCipher obj = new CaesarCipher();
        //obj.testEncrypt();
        obj.testEncryptTwoKeys();
    }
}

