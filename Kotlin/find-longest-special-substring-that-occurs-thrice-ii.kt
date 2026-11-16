package findlongestspecialsubstringthatoccursthriceii
// Time:  O(26 * 3 + n * 3)
// Space: O(26 * 3)

class Solution {
    fun maximumLength(s: String): Int {
        val lookup = Array(26) { IntArray(3) }
        var result = 0
        var cnt = 0
        for (i in s.indices) {
            ++cnt
            if (i + 1 != s.length && s[i + 1] == s[i]) {
                continue
            }
            val curr = lookup[s[i] - 'a']
            for (j in curr.indices) {
                if (curr[j] < cnt) {
                    val tmp = curr[j]
                    curr[j] = cnt
                    cnt = tmp
                }
            }
            cnt = 0
            result = maxOf(result, curr[0] - 2, minOf(curr[0] - 1, curr[1]), curr[2])
        }
        return if (result != 0) result else -1
    }
}
