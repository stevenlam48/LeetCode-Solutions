package numberofsubarraysthatmatchapatterni
// Time:  O(n)
// Space: O(m)

class Solution {
    private fun getPrefix(pattern: IntArray): IntArray {
        val prefix = IntArray(pattern.size) { -1 }
        var j = -1
        for (i in 1 until pattern.size) {
            while (j != -1 && pattern[j + 1] != pattern[i]) {
                j = prefix[j]
            }
            if (pattern[j + 1] == pattern[i]) {
                ++j
            }
            prefix[i] = j
        }
        return prefix
    }

    private fun kmp(text: IntArray, pattern: IntArray): Int {
        var result = 0
        val prefix = getPrefix(pattern)
        var j = -1
        for (value in text) {
            while (j > -1 && pattern[j + 1] != value) {
                j = prefix[j]
            }
            if (pattern[j + 1] == value) {
                ++j
            }
            if (j == pattern.size - 1) {
                ++result
                j = prefix[j]
            }
        }
        return result
    }

    fun countMatchingSubarrays(nums: IntArray, pattern: IntArray): Int {
        for (i in 0 until nums.size - 1) {
            nums[i] = when {
                nums[i + 1] > nums[i] -> 1
                nums[i + 1] < nums[i] -> -1
                else -> 0
            }
        }
        return kmp(nums, pattern)
    }
}
