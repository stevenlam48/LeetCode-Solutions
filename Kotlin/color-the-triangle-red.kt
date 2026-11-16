package colorthetrianglered

// Time:  O(n^2)
// Space: O(1)


class Solution {
    fun colorRed(n: Int): Array<IntArray> {
        val result = ArrayList<IntArray>()
        result.add(intArrayOf(1, 1))
        for (i in 2..n) {
            if (i % 2 == n % 2) {
                var j = if (i % 4 == n % 4) 1 else 3
                while (j <= 2 * i - 1) {
                    result.add(intArrayOf(i, j))
                    j += 2
                }
            } else {
                result.add(intArrayOf(i, if (i % 4 == (n - 1) % 4) 2 else 1))
            }
        }
        return result.toTypedArray()
    }
}
