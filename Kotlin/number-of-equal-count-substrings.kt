package numberofequalcountsubstrings

// Time:  O(26 * n) = O(n)
// Space: O(26) = O(1)

class Solution {
    fun equalCountSubstrings(s: String, count: Int): Int {
        var result = 0
        val maxL = minOf(s.toSet().size, s.length / count)
        for (l in 1..maxL) {
            val cnt = HashMap<Char, Int>()
            var equalCnt = 0
            for (i in s.indices) {
                val c = s[i]
                val nv = (cnt[c] ?: 0) + 1
                cnt[c] = nv
                if (nv == count) {
                    ++equalCnt
                }
                if (i >= count * l) {
                    val old = s[i - count * l]
                    val ov = cnt[old]!!
                    cnt[old] = ov - 1
                    if (ov == count) {
                        --equalCnt
                    }
                }
                if (equalCnt == l) {
                    ++result
                }
            }
        }
        return result
    }
}
