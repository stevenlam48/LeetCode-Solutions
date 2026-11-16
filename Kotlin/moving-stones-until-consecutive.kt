package movingstonesuntilconsecutive

// Time:  O(1)
// Space: O(1)

class Solution {
    fun numMovesStones(a: Int, b: Int, c: Int): IntArray {
        val s = intArrayOf(a, b, c)
        s.sort()
        if (s[0] + 1 == s[1] && s[1] + 1 == s[2]) {
            return intArrayOf(0, 0)
        }
        return intArrayOf(
            if (s[0] + 2 >= s[1] || s[1] + 2 >= s[2]) 1 else 2,
            s[2] - s[0] - 2
        )
    }
}
