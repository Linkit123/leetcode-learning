package neetcode;

import java.util.HashMap;

public class _2_ValidAnagram {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // start here
        String s = "anagramww";
        String t = "wnagaramq";
        System.out.println(Solution_1.isAnagram(s, t));

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("run time: " + totalTime);
    }

    public static class Solution {
        public static boolean isAnagram(String s, String t) {
            String[] sArr = s.split("");
            HashMap<String, Integer> sMap = countDistinctChar(sArr);
            String[] tArr = t.split("");
            HashMap<String, Integer> tMap = countDistinctChar(tArr);
            return sMap.entrySet().equals(tMap.entrySet());
        }

        private static HashMap<String, Integer> countDistinctChar(String[] s) {
            HashMap<String, Integer> output = new HashMap<>();
            for (int i = 0; i < s.length; i++) {
                String key = s[i];
                if (output.containsKey(key)) {
                    output.put(key, output.get(key) + 1);
                } else {
                    output.put(key, 1);
                }
            }
            return output;
        }
    }

    //internet solution
    //To solve the anagram problem, we can count the frequency of each letter in both strings and compare them.
    //If the frequencies of all letters are the same in both strings, then the two strings are anagrams of each other.
    public static class Solution_1 {
        public static boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] alphabet = new int[26];
            for (int i = 0; i < s.length(); i++)
            {
                alphabet[s.charAt(i) - 'a']++;
                alphabet[t.charAt(i) - 'a']--;
            }
            for (int i : alphabet) if (i != 0) return false;
            return true;
        }
    }

}
