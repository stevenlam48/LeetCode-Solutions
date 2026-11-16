package minimumnumberofoperationstomakexandyequal

// Time:  O(x)
// Space: O(x)

class Solution {
    fun minimumOperationsToMakeEqual(x: Int, y: Int): Int {
        val lookup = HashMap<Int, Int>()
        fun memoization(x: Int): Int {
            if (y >= x) {
                return y - x
            }
            if (!lookup.containsKey(x)) {
                lookup[x] = x - y
                for (d in intArrayOf(5, 11)) {
                    lookup[x] = minOf(
                        lookup[x]!!,
                        minOf(x % d, d - x % d) + memoization(x / d + if (d - x % d < x % d) 1 else 0) + 1
                    )
                }
            }
            return lookup[x]!!
        }

        return memoization(x)
    }
}
