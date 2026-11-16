package largestuniquenumber

// Time:  O(n)
// Space: O(n)

class Solution {
    fun largestUniqueNumber(A: IntArray): Int {
        val lookup = HashMap<Int, Int>()
        for (x in A) {
            lookup[x] = (lookup[x] ?: 0) + 1
        }
        var result = -1
        for ((k, v) in lookup) {
            if (v == 1) {
                result = maxOf(result, k)
            }
        }
        return result
    }
}
