package maximumnumberofequallengthruns

// Time:  O(n)
// Space: O(sqrt(n))

class Solution {
    fun maxSameLengthRuns(s: String): Int {
        val cnt = HashMap<Int, Int>()
        var l = 0
        for (i in s.indices) {
            ++l
            if (i + 1 == s.length || s[i + 1] != s[i]) {
                cnt[l] = (cnt[l] ?: 0) + 1
                l = 0
            }
        }
        return cnt.values.max()
    }
}
