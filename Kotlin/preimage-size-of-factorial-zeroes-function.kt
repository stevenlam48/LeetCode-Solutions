package preimagesizeoffactorialzeroesfunction

// Time:  O((logn)^2)
// Space: O(1)

class Solution {
    fun preimageSizeFZF(K: Int): Int {
        val p = 5
        var left = 0
        var right = p * K
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (countOfFactorialPrimes(mid, p) >= K) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return if (countOfFactorialPrimes(left, p) == K) p else 0
    }

    private fun countOfFactorialPrimes(n0: Int, p: Int): Int {
        var n = n0
        var cnt = 0
        while (n > 0) {
            cnt += n / p
            n /= p
        }
        return cnt
    }
}
