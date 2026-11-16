package numberofevenandoddbits

// Time:  O(1)
// Space: O(1)

// bit manipulation
class Solution {
    fun evenOddBit(n: Int): IntArray {
        return intArrayOf(
            Integer.bitCount(n and 0b0101010101),
            Integer.bitCount(n and 0b1010101010)
        )
    }
}
