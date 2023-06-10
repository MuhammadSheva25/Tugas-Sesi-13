// Nomor 4
// Enskripsi Modern (AES): Advanced Encryption Standard (AES) adalah salah satu enskripsi modern yang 
// digunakan secara luas. AES menggunakan blok ukuran tetap (128 bit) untuk mengenkripsi dan mendekripsi data. 
// Implementasi AES membutuhkan library kriptografi, seperti Bouncy Castle. 
// Berikut adalah contoh implementasi enskripsi AES dengan menggunakan library Bouncy Castle dalam Java:
    

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AESEncryption {
    public static byte[] encrypt(byte[] plainText, byte[] key) throws NoSuchAlgorithmException,

            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        return cipher.doFinal(plainText);
    }

    public static void main(String[] args) {
        try {
            String plainText = "HELLO WORLD";
            byte[] key = "0123456789abcdef".getBytes();

            byte[] encryptedText = encrypt(plainText.getBytes(), key);
            System.out.println("Enskripsi AES: " + new String(encryptedText));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
                | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
    }
}

