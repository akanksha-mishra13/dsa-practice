class Solution {
    public int maxVowels(String s, int k) {

        int vowelCount = 0;

        // First window
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                vowelCount++;
            }
        }

        int maxVowels = vowelCount;

        // Slide the window
        for (int right = k; right < s.length(); right++) {

            // Add the new character
            if (isVowel(s.charAt(right))) {
                vowelCount++;
            }

            // Remove the character leaving the window
            if (isVowel(s.charAt(right - k))) {
                vowelCount--;
            }

            maxVowels = Math.max(maxVowels, vowelCount);
        }

        return maxVowels;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' ||
               ch == 'e' ||
               ch == 'i' ||
               ch == 'o' ||
               ch == 'u';
    }
}