package p1bitand2bitcharacters

// Time:  O(n)
// Space: O(1)

class Solution {
    fun isOneBitCharacter(bits: IntArray): Boolean {
        var parity = 0
        var i = bits.size - 2
        while (i >= 0 && bits[i] != 0) {
            parity = parity xor bits[i]
            --i
        }
        return parity == 0
    }
}
