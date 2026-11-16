package rotateddigits

// Time:  O(logn)
// Space: O(logn)

// memoization (top-down dp)
class Solution {
    fun rotatedDigits(n: Int): Int {
        val a = ArrayList<Int>()
        var x = n
        while (x > 0) {
            a.add(x % 10)
            x /= 10
        }
        a.reverse()
        return dp(a, 0, true, false, HashMap())
    }

    private fun dp(
        a: List<Int>,
        i: Int,
        isPrefixEqual: Boolean,
        isGood: Boolean,
        lookup: HashMap<Int, Int>
    ): Int {
        if (i == a.size) {
            return if (isGood) 1 else 0
        }
        val key = i * 4 + (if (isPrefixEqual) 2 else 0) + (if (isGood) 1 else 0)
        lookup[key]?.let { return it }
        val ceil = if (isPrefixEqual) a[i] + 1 else 10
        var result = 0
        for (d in 0 until ceil) {
            if (d in INVALID) continue
            result += dp(a, i + 1, isPrefixEqual && d == a[i], isGood || d in DIFF, lookup)
        }
        lookup[key] = result
        return result
    }

    companion object {
        private val INVALID = setOf(3, 4, 7)
        private val DIFF = setOf(2, 5, 6, 9)
    }
}
