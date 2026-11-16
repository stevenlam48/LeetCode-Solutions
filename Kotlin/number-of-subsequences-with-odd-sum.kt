package numberofsubsequenceswithoddsum
// Time:  O(n)
// Space: O(1)

class Solution {
    private fun powMod(base: Int, exponent: Int, mod: Int): Int {
        var a = (base % mod).toLong()
        var b = exponent
        var result = 1L
        while (b > 0) {
            if (b and 1 == 1) {
                result = result * a % mod
            }
            a = a * a % mod
            b = b shr 1
        }
        return result.toInt()
    }

    fun subsequenceCount(nums: IntArray): Int {
        val mod = 1_000_000_007
        return if (nums.any { it % 2 == 1 }) powMod(2, nums.size - 1, mod) else 0
    }
}
