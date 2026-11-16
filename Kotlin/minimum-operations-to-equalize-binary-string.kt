package minimumoperationstoequalizebinarystring

// Time:  O(n)
// Space: O(1)

// math
class Solution {
    fun minOperations(s: String, k: Int): Int {
        fun ceilDivide(a: Int, b: Int): Int {
            return (a + b - 1) / b
        }

        val n = s.length
        val zero = s.count { it == '0' }
        if (n == k) {
            return if (zero == 0) 0 else if (zero == n) 1 else -1
        }
        var result = n + 1
        if ((k and 1) == (zero and 1)) {
            var i = maxOf(ceilDivide(zero, k), ceilDivide(n - zero, n - k))
            if ((i and 1) == 0) {
                ++i
            }
            result = minOf(result, i)
        }
        if ((zero and 1) == 0) {
            var i = maxOf(ceilDivide(zero, k), ceilDivide(zero, n - k))
            if ((i and 1) == 1) {
                ++i
            }
            result = minOf(result, i)
        }
        return if (result <= n) result else -1
    }
}
