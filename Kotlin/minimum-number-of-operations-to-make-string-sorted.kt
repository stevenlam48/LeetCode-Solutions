package minimumnumberofoperationstomakestringsorted

// Time:  O(26 * n) = O(n)
// Space: O(max_n) = O(max_n)

class Solution {
    private val inv = mutableListOf(0, 1)

    fun makeStringSorted(s: String): Int {  // count of prev_permutation
        val mod = 1_000_000_007

        val count = IntArray(26)
        var result = 0
        var combTotal = 1
        for (i in s.length - 1 downTo 0) {
            val num = s[i] - 'a'
            ++count[num]
            combTotal = (combTotal.toLong() * (s.length - i) % mod * inverse(count[num], mod) % mod).toInt()
            var sum = 0L
            for (j in 0 until num) {
                sum += count[j]
            }
            result = ((result + (combTotal.toLong() * sum % mod * inverse(s.length - i, mod) % mod)) % mod).toInt()
        }
        return result
    }

    private fun inverse(n: Int, m: Int): Int {
        var i = inv.size
        while (i <= n) {  // lazy initialization
            inv.add((inv[m % i].toLong() * (m - m / i) % m).toInt())
            ++i
        }
        return inv[n]
    }
}
