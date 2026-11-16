package numberof1bits

// Time:  O(log(logn)) = O(5)
// Space: O(1)

class Solution {
    fun hammingWeight(n: Int): Int {
        var n = n
        n = (n and 0x55555555) + ((n ushr 1) and 0x55555555)
        n = (n and 0x33333333) + ((n ushr 2) and 0x33333333)
        n = (n and 0x0F0F0F0F) + ((n ushr 4) and 0x0F0F0F0F)
        n = (n and 0x00FF00FF) + ((n ushr 8) and 0x00FF00FF)
        n = (n and 0x0000FFFF) + ((n ushr 16) and 0x0000FFFF)
        return n
    }
}
