package findtheminimumpossiblesumofabeautifularray

// Time:  O(1)
// Space: O(1)

// constructive algorithms, math
class Solution {
    fun minimumPossibleSum(n: Int, target: Int): Long {
        fun arithmeticProgressionSum(a: Long, d: Long, n: Long): Long =
            (a + (a + (n - 1) * d)) * n / 2

        val a = minOf(target / 2, n).toLong()
        val b = n - a
        return arithmeticProgressionSum(1, 1, a) + arithmeticProgressionSum(target.toLong(), 1, b)
    }
}
