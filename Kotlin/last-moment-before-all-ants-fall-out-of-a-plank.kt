package lastmomentbeforeallantsfalloutofaplank

// Time:  O(n)
// Space: O(1)

class Solution {
    fun getLastMoment(n: Int, left: IntArray, right: IntArray): Int {
        return maxOf(left.maxOrNull() ?: 0, if (right.isNotEmpty()) n - (right.minOrNull() ?: 0) else 0)
    }
}
