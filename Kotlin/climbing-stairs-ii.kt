package climbingstairsii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun climbStairs(n: Int, costs: IntArray): Int {
        val inf = Int.MAX_VALUE

        var a = inf
        var b = inf
        var c = 0
        for (i in 0 until n) {
            val next = costs[i] + minOf(
                if (i - 2 >= 0) a + 3 * 3 else inf,
                if (i - 1 >= 0) b + 2 * 2 else inf,
                c + 1 * 1
            )
            a = b
            b = c
            c = next
        }
        return c
    }
}
