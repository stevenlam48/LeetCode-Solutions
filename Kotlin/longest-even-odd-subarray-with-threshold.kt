package longestevenoddsubarraywiththreshold

// Time:  O(n)
// Space: O(1)

class Solution {
    fun longestAlternatingSubarray(nums: IntArray, threshold: Int): Int {
        var result = 0
        var l = 0
        for (x in nums) {
            if (x > threshold) {
                l = 0
                continue
            }
            if (l % 2 == x % 2) {
                ++l
            } else {
                l = (x + 1) % 2
            }
            result = maxOf(result, l)
        }
        return result
    }
}
