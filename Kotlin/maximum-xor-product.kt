package maximumxorproduct

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumXorProduct(a0: Long, b0: Long, n: Int): Int {
        val MOD = 1_000_000_007L

        var a = a0
        var b = b0
        for (i in n - 1 downTo 0) {
            val base = 1L shl i
            if ((minOf(a, b) and base) == 0L) {
                a = a xor base
                b = b xor base
            }
        }
        return ((a % MOD) * (b % MOD) % MOD).toInt()
    }
}
