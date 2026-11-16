package shiftdistancebetweentwostrings

// Time:  O(n + 26)
// Space: O(26)

class Solution {
    fun shiftDistance(s: String, t: String, nextCost: IntArray, previousCost: IntArray): Long {
        val prefix1 = LongArray(nextCost.size + 1)
        for (i in nextCost.indices) {
            prefix1[i + 1] = prefix1[i] + nextCost[i]
        }
        val prefix2 = LongArray(previousCost.size + 1)
        for (i in previousCost.indices) {
            prefix2[i + 1] = prefix2[i] + previousCost[i]
        }
        var result = 0L
        for (i in s.indices) {
            if (s[i] == t[i]) {
                continue
            }
            val left = s[i] - 'a'
            val right = t[i] - 'a'
            result += if (left <= right) {
                minOf(
                    prefix1[right] - prefix1[left],
                    prefix2.last() - (prefix2[right + 1] - prefix2[left + 1])
                )
            } else {
                minOf(
                    prefix2[left + 1] - prefix2[right + 1],
                    prefix1.last() - (prefix1[left] - prefix1[right])
                )
            }
        }
        return result
    }
}
