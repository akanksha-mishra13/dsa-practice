class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int windowSum = 0;
        int count = 0;

        // First window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        // Averages >= threshold means:
        // sum >= k * threshold
        int requiredSum = k * threshold;

        if (windowSum >= requiredSum) {
            count++;
        }

        // Slide the window
        for (int right = k; right < arr.length; right++) {
            windowSum += arr[right];
            windowSum -= arr[right - k];

            if (windowSum >= requiredSum) {
                count++;
            }
        }

        return count;
    }
}