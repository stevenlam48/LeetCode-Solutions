package minimumbitflipstoconvertnumber

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun minBitFlips(start: Int, goal: Int): Int {
        return (start xor goal).countOneBits()
    }
}
