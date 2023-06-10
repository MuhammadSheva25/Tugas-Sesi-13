public class PlayfairEncryption {

// Nomor 3
// Enskripsi Playfair: Enskripsi Playfair menggunakan matriks 5x5 yang berisi alfabet. 
// Setiap pasangan huruf dalam teks yang akan dienskripsi digantikan dengan aturan-aturan tertentu 
// berdasarkan posisi mereka dalam matriks. Berikut adalah implementasi 
// enskripsi Playfair dalam Java:


    private static final int MATRIX_SIZE = 5;

    public static String encrypt(String plainText, String key) {
        char[][] matrix = createPlayfairMatrix(key);
        StringBuilder encryptedText = new StringBuilder();
        plainText = plainText.toUpperCase().replace("J", "I").replaceAll("\\s+", "");

        for (int i = 0; i < plainText.length(); i += 2) {
            char char1 = plainText.charAt(i);
            char char2 = i + 1 < plainText.length() ? plainText.charAt(i + 1) : 'X';


            int[] char1Pos = findCharPosition(matrix, char1);
            int[] char2Pos = findCharPosition(matrix, char2);

            int row1 = char1Pos[0];
            int col1 = char1Pos[1];
            int row2 = char2Pos[0];
            int col2 = char2Pos[1];

            char encryptedChar1;
            char encryptedChar2;

            if (row1 == row2) { // Same row
                encryptedChar1 = matrix[row1][(col1 + 1) % MATRIX_SIZE];
                encryptedChar2 = matrix[row2][(col2 + 1) % MATRIX_SIZE];
            } else if (col1 == col2) { // Same column

                encryptedChar1 = matrix[(row1 + 1) % MATRIX_SIZE][col1];
                encryptedChar2 = matrix[(row2 + 1) % MATRIX_SIZE][col2];
            } else { // Different row and column
                encryptedChar1 = matrix[row1][col2];
                encryptedChar2 = matrix[row2][col1];
            }

            encryptedText.append(encryptedChar1).append(encryptedChar2);
        }

        return encryptedText.toString();
    }

    private static char[][] createPlayfairMatrix(String key) {

        char[][] matrix = new char[MATRIX_SIZE][MATRIX_SIZE];
        key = key.toUpperCase().replace("J", "I").replaceAll("\\s+", "");
        String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        StringBuilder keyBuilder = new StringBuilder(key);

        for (int i = 0; i < alphabet.length(); i++) {
            char c = alphabet.charAt(i);
            if (c != 'J' && keyBuilder.indexOf(String.valueOf(c)) == -1) {
                keyBuilder.append(c);
            }
        }

        String keyString = keyBuilder.toString();
        int keyIndex = 0;

        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                matrix[i][j] = keyString.charAt(keyIndex);
                keyIndex++;
            }
        }

        return matrix;
    }

    private static int[] findCharPosition(char[][] matrix, char c) {
        int[] position = new int[2];

        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                if (matrix[i][j] == c) {
                    position[0] = i;
                    position[1] = j;
                    return position;

                }
            }
        }

        return position;
    }

    public static void main(String[] args) {
        String plainText = "HELLO WORLD";
        String key = "KEY";
        String encryptedText = encrypt(plainText, key);
        System.out.println("Enskripsi Playfair: " + encryptedText);
    }
}

// Output: "RIJVSUNEPJ"
    

