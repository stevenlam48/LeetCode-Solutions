package transformbinarystringusingsubsequencesort
// Time:  O(n * m)
// Space: O(n)

class Solution {
    fun transformStr(s: String, strs: List<String>): BooleanArray {
        val prefix = IntArray(s.length + 1)
        for (i in s.indices) {
            prefix[i + 1] = prefix[i] + if (s[i] == '1') 1 else 0
        }
        val result = BooleanArray(strs.size)
        for (i in strs.indices) {
            var left = 0
            var right = 0
            for (j in strs[i].indices) {
                left += if (strs[i][j] == '1') 1 else 0
                right = minOf(right + if (strs[i][j] != '0') 1 else 0, prefix[j + 1])
                if (left > right) {
                    break
                }
            }
            result[i] = left <= prefix.last() && prefix.last() <= right
        }
        return result
    }
}
