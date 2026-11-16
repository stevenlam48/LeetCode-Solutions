package countsubstringsthatsatisfykconstraintii
// Time:  O(n)
// Space: O(n)

class Solution {
    fun countKConstraintSubstrings(s: String, k: Int, queries: Array<IntArray>): LongArray {
        fun count(l: Long): Long {
            return (l + 1) * l / 2
        }

        val prefix = LongArray(s.length + 1)
        val lookup = IntArray(s.length) { -1 }
        var left = 0
        var cnt = 0
        for (right in s.indices) {
            cnt += if (s[right] == '1') 1 else 0
            while (!(cnt <= k || right - left + 1 - cnt <= k)) {
                cnt -= if (s[left] == '1') 1 else 0
                ++left
            }
            prefix[right + 1] = prefix[right] + right - left + 1
            lookup[left] = right
        }
        assert(lookup[0] != -1)
        for (i in 0 until s.length - 1) {
            if (lookup[i + 1] == -1) {
                lookup[i + 1] = lookup[i]
            }
        }
        val result = LongArray(queries.size)
        for (i in queries.indices) {
            left = queries[i][0]
            val right = queries[i][1]
            val newRight = minOf(lookup[left], right)
            result[i] = count((newRight - left + 1).toLong()) + prefix[right + 1] - prefix[newRight + 1]
        }
        return result
    }
}
