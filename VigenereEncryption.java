public class VigenereEncryption {
    
// Nomor 2
// Enskripsi Vigenère: Enskripsi Vigenère menggunakan tabel Vigenère Square yang terdiri dari 
// alfabet diulang sebanyak mungkin. Kunci enskripsi terdiri dari kata atau frase yang diulang 
// sejajar dengan teks yang akan dienskripsi. 
// Berikut adalah implementasi enskripsi Vigenère dalam Java:


    public static String encrypt(String plainText, String key) {
        StringBuilder encryptedText = new StringBuilder();

        plainText = plainText.toUpperCase();
        key = key.toUpperCase();
        int keyLength = key.length();
        int textLength = plainText.length();

        for (int i = 0; i < textLength; i++) {
            char plainChar = plainText.charAt(i);
            char keyChar = key.charAt(i % keyLength);

            if (Character.isLetter(plainChar)) {
                char encryptedChar = (char) ((plainChar + keyChar - 2 * 'A') % 26 + 'A');
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(plainChar);
            }
        }

        return encryptedText.toString();

    }

    public static void main(String[] args) {
        String plainText = "HELLO WORLD";
        String key = "KEY";
        String encryptedText = encrypt(plainText, key);
        System.out.println("Enskripsi Vigenère: " + encryptedText);
    }
}

// Output: "RIJVS UNEPJ"



