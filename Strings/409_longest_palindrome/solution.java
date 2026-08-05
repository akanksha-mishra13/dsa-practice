class Solution {

    public int longestPalindrome(String s) {

        int[] frequency = new int[128];

        for (char ch : s.toCharArray()) {
            frequency[ch]++;
        }

        int length = 0;
        boolean hasOdd = false;

        for (int count : frequency) {

            if (count % 2 == 0) {
                length += count;
            } else {
                length += count - 1;
                hasOdd = true;
            }
        }

        if (hasOdd) {
            length++;
        }

        return length;
    }
}