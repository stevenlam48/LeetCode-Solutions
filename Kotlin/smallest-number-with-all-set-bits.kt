package smallestnumberwithallsetbits
// Time:  O(1)
// Space: O(1)

class Solution {
    fun smallestNumber(n: Int): Int {
        val bitLength = if (n != 0) 32 - Integer.numberOfLeadingZeros(n) else 0
        return (1 shl bitLength) - 1
    }
}
