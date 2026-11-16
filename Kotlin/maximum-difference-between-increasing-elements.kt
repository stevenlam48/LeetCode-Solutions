package maximumdifferencebetweenincreasingelements

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumDifference(nums: IntArray): Int {
        var result = 0
        var prefix = Int.MAX_VALUE
        for (x in nums) {
            result = maxOf(result, x - prefix)
            prefix = minOf(prefix, x)
        }
        return if (result != 0) result else -1
    }
}
