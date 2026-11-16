package numberofbeautifulintegersintherange

// Time:  O(n^2 * k), n = len(str(high))
// Space: O(n^2 * k)

class Solution {
    fun numberOfBeautifulIntegers(low: Int, high: Int, k: Int): Int {
        val TIGHT = 0
        val UNTIGHT = 1
        val UNBOUND = 2

        fun toDigits(x0: Int): IntArray {
            var x = x0
            val result = ArrayList<Int>()
            while (x != 0) {
                result.add(x % 10)
                x /= 10
            }
            result.reverse()
            return if (result.isNotEmpty()) result.toIntArray() else intArrayOf(0)
        }

        fun f(x: Int): Int {
            val digits = toDigits(x)
            val n = digits.size
            val lookup = Array(n) { Array(3) { Array(2 * n + 1) { IntArray(k) { -1 } } } }

            fun memoization(i: Int, state: Int, diff: Int, total: Int): Int {
                if (i == n) {
                    return if (state != UNBOUND && diff == n && total == 0) 1 else 0
                }
                if (lookup[i][state][diff][total] == -1) {
                    var result = if (i != 0 && diff == n && total == 0) 1 else 0
                    for (d in (if (i == 0) 1 else 0)..9) {
                        var newState = state
                        if (state == TIGHT && d != digits[i]) {
                            newState = if (d < digits[i]) UNTIGHT else UNBOUND
                        }
                        val newDiff = diff + (if (d % 2 == 0) 1 else -1)
                        val newTotal = (total * 10 + d) % k
                        result += memoization(i + 1, newState, newDiff, newTotal)
                    }
                    lookup[i][state][diff][total] = result
                }
                return lookup[i][state][diff][total]
            }

            return memoization(0, TIGHT, n, 0)
        }

        return f(high) - f(low - 1)
    }
}
