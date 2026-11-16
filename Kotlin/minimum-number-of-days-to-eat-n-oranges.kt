package minimumnumberofdaystoeatnoranges

// Time:  O((logn)^2)
// Space: O((logn)^2)

class Solution {
    fun minDays(n: Int): Int {
        val lookup = HashMap<Int, Int>()
        return memoization(n, lookup)
    }

    private fun memoization(i: Int, lookup: HashMap<Int, Int>): Int {
        if (i <= 1) {
            return i
        }
        if (!lookup.containsKey(i)) {
            lookup[i] = 1 + minOf(
                i % 2 + memoization(i / 2, lookup),
                i % 3 + memoization(i / 3, lookup)
            )
        }
        return lookup[i]!!
    }
}
