package minimumoperationstomakearrayelementszero

// Time:  O(qlogr)
// Space: O(1)

class Solution {
    fun minOperations(queries: Array<IntArray>): Long {
        var result = 0L
        for (q in queries) {
            val l = q[0].toLong()
            val r = q[1].toLong()
            var total = 0L
            var base = 1L
            var i = 1L
            while (base <= r) {
                val nl = maxOf(l, base)
                val nr = minOf(r, base * 4 - 1)
                if (nl <= nr) {
                    total += i * (nr - nl + 1)
                }
                base *= 4
                ++i
            }
            result += (total + 1) / 2
        }
        return result
    }
}
