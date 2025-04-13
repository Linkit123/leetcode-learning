package test.assignment;

/**
 * Phần 1: Coding algorithms
 * Phần 2: 16 câu hỏi trắc nghiệm về spring
 * Phần 3: Coding SQL entry level
 * Phần 4: 16 câu trắc nghiệm tiếng anh C1(Advanced)

 * Coding in Java: You are given a string of encrypted text (ciphertext).
 * The encryption algorithm used to create the ciphertext simply shifts all the alphabetic characters in the original (unencrypted) string by the same amount. But you don't know what this amount is.
 * Write the decipher function that takes the encrypted string as input, and returns the original, unencrypted string.
 * For example, imagine that the original message was "hello" and we shifted each
 * letter by two. The resulting ciphertext would be "jgnnq".
 * If the original message were "Coding tests are fun and challenging!" and we shifted each character by two, the resulting ciphertext would be "Eqfkpi vguvu ctg hwp cpf ejcnngpikpi!"
 * The decipher function takes two arguments: the ciphertext, and a word that we know appeared in the original plain text. Using these clues, the function must output the original text.
 * We will follow the English alphabet for this question. Note that the last letter of the alphabet Z will be followed by A. Likewise, z will be followed by a.
 * If the word you are searching for in the original string does not appear threre, return "Invalid".

 * 1. Example 1:
 * Input:
 * - "Eqfkpi vguvu ctg hwp!"
 * - "tests"
 * Output:
 * - "Coding tests are fun!"
 * Explanation:
 * - "tests" is a five-letter word. In the encrypted string, the only five-letter word is "vguvu". Therefore the encrypted version of "tests" may be "vguvu". On comparing "tests" to "vguvu", it is clear that the encryption process has shifted every character in the plaintext by 2. So, the plaintext in this case is "Coding tests are fun!".
 * Example 2 Input:
 * - "cdeb nqxg"
 * - "love"
 * Output:
 * - "abcz love"

 * 2. Example 2
 * Input:
 * - "cdeb nqxg"
 * - "love"
 * Output:
 * - "abcz love"
 * Explanation:
 * - In this case, "love" could have been encrypted to either "cdeb" or "nqxg". On closer examination, it is clear that "nqxg" is the correct option, with every character shifted by 2. (No such relationship exists between "love" and "cdeb")
 */
public class IntergroTech {

    /*
    1. Splitting the Ciphertext: The function splits the ciphertext into words and iterates over each word.
    2. Brute-Force Shifting: It shifts each word backward (up to 26 times) to check if it matches the known word.
    3. Finding the Shift Value: Once a match is found, it decrypts the entire text using that shift value.
    4. Decryption Logic:
        If a character is a letter, it shifts it back within the alphabet using modular arithmetic.
        Non-alphabetic characters remain unchanged.
    5. Returning the Result: If no match is found, it returns "Invalid".*/
    public static String decipher(String ciphertext, String knownWord) {
        String[] words = ciphertext.split(" ");

        for (String encryptedWord : words) {
            for (int shift = 1; shift <= 26; shift++) {
                String decryptedWord = shiftDecrypt(encryptedWord, shift);
                if (decryptedWord.equals(knownWord)) {
                    return shiftDecrypt(ciphertext, shift);
                }
            }
        }
        return "Invalid";
    }

    private static String shiftDecrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char decryptedChar = (char) ((c - base - shift + 26) % 26 + base);
                result.append(decryptedChar);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    /*
    * 1. Split the ciphertext into words
    * 2. Determine the shift using the second word and the known word
    * 3. Calculate the shift based on the first alphabetic character
    * 4. Decipher the entire ciphertext
    * */
    public static String decipher2(String ciphertext, String knownWord) {
        // Split the ciphertext into words
        String[] parts = ciphertext.split(" ");
        if (parts.length < 2) {
            return "Invalid ciphertext format";
        }

        // Determine the shift using the second word and the known word
        String cipherSecondWord = parts[1];
        if (cipherSecondWord.length() != knownWord.length()) {
            return "Length mismatch between cipher word and known word";
        }

        // Calculate the shift based on the first alphabetic character
        int shift = 0;
        for (int i = 0; i < cipherSecondWord.length(); i++) {
            if (Character.isLetter(cipherSecondWord.charAt(i))) {
                shift = (cipherSecondWord.charAt(i) - knownWord.charAt(i) + 26) % 26;
                break;
            }
        }

        // Decipher the entire ciphertext
        StringBuilder cleartext = new StringBuilder();
        for (char c : ciphertext.toCharArray()) {
            if (Character.isLetter(c)) {
                // Apply shift to letters only
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int position = c - base;
                int newPosition = (position - shift + 26) % 26;
                char newChar = (char) (base + newPosition);
                cleartext.append(newChar);
            } else {
                // Preserve spaces and special characters
                cleartext.append(c);
            }
        }

        return cleartext.toString();
    }

    public static String decipher3(String ciphertext, String knownWord) {
        // find shift amount
        String[] words = ciphertext.split(" ");
        int shift = findShift(words, knownWord);
        System.out.println("shift: " + shift);

        // find shift value by shift back with above amount
        String decipherText = "";

        for(int i = 0; i <= ciphertext.length() - 1; i++) {      
            char c = ciphertext.charAt(i);
            if (Character.isLetter(c)) {
                // Apply shift to letters only
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char newChar = (char) (base + (c - base + 26) % 26);
                decipherText += newChar;
            } else {
                decipherText += c;
            }
            
        }

        return decipherText;
    }

    private static int findShift(String[] words, String knownWord) {
        for(String word : words) {
            for(int i = 1; i <= 25; i++) {
                 String decipherText = "";
                 for(int j = 0; j <= word.length() - 1; j++) {
                     int a = word.charAt(j);
                     decipherText += (char) (a - i);
                 }
                 if (decipherText.equals(knownWord)) {
                     return i;
                 }
            }
         }
         return 0;
    }

    public static void main(String[] args) {
//         System.out.println(decipher3("Eqfkpi vguvu ctg hwp!", "tests")); // Output: "Coding tests are fun!"
        System.out.println(decipher3("cdeb nqxg", "love")); // Output: "abcz love"
    }
}
