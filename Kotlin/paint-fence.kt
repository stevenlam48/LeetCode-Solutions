package paintfence
// Time:  O(n)
// Space: O(1)

class Solution {
    fun numWays(n: Int, k: Int): Int {
        if (n == 0) {
            return 0
        } else if (n == 1) {
            return k
        }
        val ways = IntArray(3)
        ways[0] = k
        ways[1] = (k - 1) * ways[0] + k
        for (i in 2 until n) {
            ways[i % 3] = (k - 1) * (ways[(i - 1) % 3] + ways[(i - 2) % 3])
        }
        return ways[(n - 1) % 3]
    }
}
