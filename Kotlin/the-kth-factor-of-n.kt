package thekthfactorofn

// Time:  O(sqrt(n))
// Space: O(1)

class Solution {
    fun kthFactor(n: Int, k: Int): Int {
        val (mid, count) = kthFactor_(n)
        val total = 2 * count - (if (mid * mid == n) 1 else 0)
        if (k > total) {
            return -1
        }
        val result = kthFactor_(n, if (k <= count) k else total - (k - 1)).first
        return if (k <= count) result else n / result
    }

    private fun kthFactor_(n: Int, k0: Int = 0): Pair<Int, Int> {
        var k = k0
        var mid = -1
        var i = 1
        while (i * i <= n) {
            if (n % i == 0) {
                mid = i
                if (--k == 0) {
                    break
                }
            }
            ++i
        }
        return Pair(mid, -k)
    }
}
