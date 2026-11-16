package longestwellperforminginterval

// Time:  O(n)
// Space: O(n)

class Solution {
    fun longestWPI(hours: IntArray): Int {
        var result = 0
        var accu = 0
        val lookup = HashMap<Int, Int>()
        for (i in hours.indices) {
            accu += if (hours[i] > 8) 1 else -1
            if (accu > 0) {
                result = i + 1
            } else if (lookup.containsKey(accu - 1)) {
                result = maxOf(result, i - lookup[accu - 1]!!)
            }
            if (!lookup.containsKey(accu)) {
                lookup[accu] = i
            }
        }
        return result
    }
}
