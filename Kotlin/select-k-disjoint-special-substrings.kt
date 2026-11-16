package selectkdisjointspecialsubstrings

// Time:  O(n + 26^3)
// Space: O(26)

class Solution {
    fun maxSubstringLength(s: String, k: Int): Boolean {
        fun eraseOverlapIntervals(intervals: MutableList<IntArray>): Int {
            intervals.sortWith(compareBy { it[1] })
            var result = 0
            var right = Int.MIN_VALUE
            for (x in intervals) {
                if (x[0] <= right) {
                    ++result
                } else {
                    right = x[1]
                }
            }
            return result
        }

        val cnt = IntArray(26)
        val lookup1 = IntArray(26) { -1 }
        val lookup2 = IntArray(26) { -1 }
        for (i in s.indices) {
            ++cnt[s[i] - 'a']
            if (lookup1[s[i] - 'a'] == -1) {
                lookup1[s[i] - 'a'] = i
            }
            lookup2[s[i] - 'a'] = i
        }
        val intervals = mutableListOf<IntArray>()
        for (i in lookup1) {
            if (i == -1) {
                continue
            }
            for (j in lookup2) {
                if (j == -1 || i > j) {
                    continue
                }
                var total = 0
                for (c in cnt.indices) {
                    if (i <= lookup1[c] && lookup1[c] <= lookup2[c] && lookup2[c] <= j) {
                        total += cnt[c]
                    }
                }
                if (total == j - i + 1 && total < s.length) {
                    intervals.add(intArrayOf(i, j))
                }
            }
        }
        return intervals.size - eraseOverlapIntervals(intervals) >= k
    }
}
