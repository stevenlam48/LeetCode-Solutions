package splittingastringintodescendingconsecutivevalues

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun splitString(s: String): Boolean {
        return backtracking(s, 0, -1, 0)
    }

    private fun backtracking(s: String, i: Int, num: Long, cnt: Int): Boolean {
        if (i == s.length) {
            return cnt >= 2
        }
        var newNum = 0L
        for (j in i until s.length) {
            newNum = newNum * 10 + (s[j] - '0')
            if (newNum >= 10_000_000_000L) {
                break
            }
            if (newNum >= num && num >= 0) {
                break
            }
            if ((num == -1L || num - 1 == newNum) && backtracking(s, j + 1, newNum, cnt + 1)) {
                return true
            }
        }
        return false
    }
}
