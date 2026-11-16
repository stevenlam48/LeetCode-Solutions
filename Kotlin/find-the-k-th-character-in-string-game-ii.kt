package findthekthcharacterinstringgameii

// Time:  O(logr) = O(1)
// Space: O(1)

class Solution {
    fun kthCharacter(k0: Long, operations: IntArray): Char {
        fun bitLength(x: Long): Int = if (x != 0L) 64 - java.lang.Long.numberOfLeadingZeros(x) else 0

        var k = k0
        var result = 0
        k -= 1
        val limit = minOf(operations.size.toLong(), bitLength(k).toLong()).toInt()
        for (i in 0 until limit) {
            if ((k and (1L shl i)) != 0L) {
                result = (result + operations[i]) % 26
            }
        }
        return 'a' + result
    }
}
