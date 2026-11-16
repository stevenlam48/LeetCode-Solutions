package reversebits

// Time:  O(32)
// Space: O(1)

class Solution {
    fun reverseBits(n0: Int): Int {
        var n = n0
        n = (n ushr 16) or (n shl 16)
        n = ((n and 0xff00ff00.toInt()) ushr 8) or ((n and 0x00ff00ff) shl 8)
        n = ((n and 0xf0f0f0f0.toInt()) ushr 4) or ((n and 0x0f0f0f0f) shl 4)
        n = ((n and 0xcccccccc.toInt()) ushr 2) or ((n and 0x33333333) shl 2)
        n = ((n and 0xaaaaaaaa.toInt()) ushr 1) or ((n and 0x55555555) shl 1)
        return n
    }
}
