package numberofgoodwaystosplitastring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun numSplits(s: String): Int {
        val left = IntArray(26)
        val right = IntArray(26)
        var rightCount = 0
        for (c in s) {
            right[c - 'a']++
            if (right[c - 'a'] == 1) {
                ++rightCount
            }
        }
        var result = 0
        var leftCount = 0
        for (c in s) {
            left[c - 'a']++
            if (left[c - 'a'] == 1) {
                ++leftCount
            }
            right[c - 'a']--
            if (right[c - 'a'] == 0) {
                --rightCount
            }
            if (leftCount == rightCount) {
                ++result
            }
        }
        return result
    }
}
