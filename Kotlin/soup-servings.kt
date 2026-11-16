package soupservings

// Time:  O(1)
// Space: O(1)

class Solution {
    fun soupServings(N: Int): Double {
        if (N > 4800) {
            return 1.0
        }
        val lookup = HashMap<Pair<Int, Int>, Double>()
        val n = (N + 24) / 25
        return dp(n, n, lookup)
    }

    private fun dp(a: Int, b: Int, lookup: HashMap<Pair<Int, Int>, Double>): Double {
        val key = Pair(a, b)
        lookup[key]?.let { return it }
        if (a <= 0 && b <= 0) {
            return 0.5
        }
        if (a <= 0) {
            return 1.0
        }
        if (b <= 0) {
            return 0.0
        }
        val result = 0.25 * (dp(a - 4, b, lookup) +
                dp(a - 3, b - 1, lookup) +
                dp(a - 2, b - 2, lookup) +
                dp(a - 1, b - 3, lookup))
        lookup[key] = result
        return result
    }
}
