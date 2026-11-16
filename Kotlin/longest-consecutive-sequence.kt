package longestconsecutivesequence

// Time:  O(n)
// Space: O(n)

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val unprocessedEntries = nums.toHashSet()
        var maxIntervalSize = 0
        while (unprocessedEntries.isNotEmpty()) {
            val num = unprocessedEntries.first()
            unprocessedEntries.remove(num)
            var lowerBound = num - 1
            while (lowerBound in unprocessedEntries) {
                unprocessedEntries.remove(lowerBound)
                --lowerBound
            }
            var upperBound = num + 1
            while (upperBound in unprocessedEntries) {
                unprocessedEntries.remove(upperBound)
                ++upperBound
            }
            maxIntervalSize = maxOf(maxIntervalSize, upperBound - lowerBound - 1)
        }
        return maxIntervalSize
    }
}
