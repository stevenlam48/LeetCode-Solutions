package maximizeysumbypickingatripletofdistinctxvalues

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxSumDistinctTriplet(x: IntArray, y: IntArray): Int {
        val K = 3
        val lookup = HashMap<Int, Int>()
        for (i in x.indices) {
            lookup[x[i]] = maxOf(lookup[x[i]] ?: Int.MIN_VALUE, y[i])
        }
        if (lookup.size < K) {
            return -1
        }
        val vals = lookup.values.sortedDescending()
        var result = 0
        for (i in 0 until K) {
            result += vals[i]
        }
        return result
    }
}
