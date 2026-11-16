package permutationinstring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val counts = IntArray(256)
        for (c in s1) {
            ++counts[c.code]
        }
        var l = s1.length
        for (i in s2.indices) {
            val c = s2[i].code
            val old = counts[c]
            counts[c] = old - 1
            if (old > 0) {
                --l
            }
            if (l == 0) {
                return true
            }
            val start = i + 1 - s1.length
            if (start >= 0) {
                val sc = s2[start].code
                ++counts[sc]
                if (counts[sc] > 0) {
                    ++l
                }
            }
        }
        return false
    }
}
