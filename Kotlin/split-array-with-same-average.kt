package splitarraywithsameaverage

// Time:  O(n^4)
// Space: O(n^3)

class Solution {
    fun splitArraySameAverage(A: IntArray): Boolean {
        val n = A.size
        val sum = A.sum()
        if (!possible(n, sum)) {
            return false
        }

        val sums = Array(n / 2 + 1) { hashSetOf<Int>() }
        sums[0].add(0)
        for (num in A) {
            for (i in n / 2 downTo 1) {
                for (prev in sums[i - 1]) {
                    sums[i].add(prev + num)
                }
            }
        }
        for (i in 1..n / 2) {
            if (sum * i % n == 0 && sum * i / n in sums[i]) {
                return true
            }
        }
        return false
    }

    private fun possible(n: Int, sum: Int): Boolean {
        for (i in 1..n / 2) {
            if (sum * i % n == 0) {
                return true
            }
        }
        return false
    }
}
