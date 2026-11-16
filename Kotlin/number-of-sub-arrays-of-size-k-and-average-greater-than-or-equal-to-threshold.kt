package numberofsubarraysofsizekandaveragegreaterthanorequaltothreshold
// Time:  O(n)
// Space: O(1)

class Solution {
    fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {
        var result = 0
        var current = 0L
        for (i in 0 until k - 1) {
            current += arr[i]
        }
        for (i in k - 1 until arr.size) {
            current += arr[i] - if (i - k >= 0) arr[i - k] else 0
            if (current >= k.toLong() * threshold) {
                ++result
            }
        }
        return result
    }
}
