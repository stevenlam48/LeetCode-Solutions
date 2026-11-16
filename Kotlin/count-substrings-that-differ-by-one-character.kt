package countsubstringsthatdifferbyonecharacter
// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun countSubstrings(s: String, t: String): Int {
        var result = 0
        for (i in s.indices) {
            result += count(s, t, i, 0)
        }
        for (j in 1 until t.length) {
            result += count(s, t, 0, j)
        }
        return result
    }

    private fun count(s: String, t: String, i: Int, j: Int): Int {
        val l = minOf(s.length - i, t.length - j)
        var result = 0
        var leftCnt = 0
        var rightCnt = 0
        for (k in 0 until l) {
            ++rightCnt
            if (s[i + k] != t[j + k]) {
                leftCnt = rightCnt
                rightCnt = 0
            }
            result += leftCnt
        }
        return result
    }
}
