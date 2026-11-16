package findthepunishmentnumberofaninteger

// Time:  O(n * (logn)^(2*logn))
// Space: O(2*logn)

class Solution {
    fun punishmentNumber(n: Int): Int {
        fun backtracking(curr: Int, target: Int): Boolean {
            if (target == 0) {
                return curr == 0
            }
            var base = 10
            while (base / 10 <= curr) {
                val q = curr / base
                val r = curr % base
                if (target - r < 0) {
                    break
                }
                if (backtracking(q, target - r)) {
                    return true
                }
                base *= 10
            }
            return false
        }

        var result = 0
        for (i in 1..n) {
            if (backtracking(i * i, i)) {
                result += i * i
            }
        }
        return result
    }
}
