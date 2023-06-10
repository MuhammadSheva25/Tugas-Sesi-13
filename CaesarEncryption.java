public class CaesarEncryption {
// Nomor 1
// Enskripsi Caesar: Enskripsi Caesar adalah salah satu enskripsi klasik yang paling sederhana. 
// Caranya adalah dengan menggantikan setiap huruf dengan huruf lain yang terletak beberapa posisi ke kanan dalam alfabet. 
// Misalnya, jika menggunakan pergeseran 3, huruf A akan digantikan dengan huruf D, huruf B dengan E, dan seterusnya. 
// Berikut adalah implementasi enskripsi Caesar dalam Java:



    public static String encrypt(String plainText, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (char c : plainText.toCharArray()) {
            if (Character.isLetter(c)) {

                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char encryptedChar = (char) ((c - base + shift) % 26 + base);
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(c);
            }
        }

        return encryptedText.toString();
    }

    public static void main(String[] args) {
        String plainText = "HELLO WORLD";
        int shift = 3;
        String encryptedText = encrypt(plainText, shift);
        System.out.println("Enskripsi Caesar: " + encryptedText);

    }
}

// Output: "KHOOR ZROUG"


