class Solution {
    public boolean halvesAreAlike(String s) {

        int count1 = 0;
        int count2 = 0;

        int mid = s.length() / 2;

        // First half
        for (int i = 0; i < mid; i++) {
            if (isVowel(s.charAt(i))) {
                count1++;
            }
        }

        // Second half
        for (int i = mid; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                count2++;
            }
        }

        return count1 == count2;
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' ||
               c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' ||
               c == 'O' || c == 'U';
    }
}