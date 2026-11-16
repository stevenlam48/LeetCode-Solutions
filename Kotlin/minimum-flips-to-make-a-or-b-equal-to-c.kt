package minimumflipstomakeaorbequaltoc

// Time:  O(5)
// Space: O(1)

class Solution {
    fun minFlips(a: Int, b: Int, c: Int): Int {
        return numberOf1Bits((a or b) xor c) + numberOf1Bits(a and b and c.inv())
    }

    private fun numberOf1Bits(n0: Int): Int {
        var n = n0
        n = (n and 0x55555555) + ((n shr 1) and 0x55555555)
        n = (n and 0x33333333) + ((n shr 2) and 0x33333333)
        n = (n and 0x0F0F0F0F) + ((n shr 4) and 0x0F0F0F0F)
        n = (n and 0x00FF00FF) + ((n shr 8) and 0x00FF00FF)
        n = (n and 0x0000FFFF) + ((n shr 16) and 0x0000FFFF)
        return n
    }
}
