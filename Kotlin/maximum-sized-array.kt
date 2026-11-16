package maximumsizedarray

// Time:  precompute: O(max_s^(1/5) * log(max_s))
//        runtime:    O(log(max_s))
// Space: O(max_s^(1/5))

class Solution {
    fun maxSizedArray(s: Long): Int {
        while (vol.last() <= s) {
            val l = bitLength(i - 1)
            var line = (i - 1) * i
            for (bit in 0 until l) {
                if ((i - 1) and (1 shl bit) == 0) {
                    line += (((i - 1) shr (bit + 1)) * (1 shl bit)) * (1 shl bit)
                }
            }
            area += 2L * line - ((i - 1) or (i - 1))
            vol.add(((i - 1).toLong() * i / 2) * area)
            i++
        }
        var lo = 0
        var hi = vol.size
        while (lo < hi) {
            val mid = (lo + hi) / 2
            if (vol[mid] <= s) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lo - 1
    }

    private fun bitLength(x: Int): Int = if (x != 0) 32 - Integer.numberOfLeadingZeros(x) else 0

    companion object {
        private var i = 1
        private var area = 0L
        private val vol = mutableListOf(0L)
    }
}
