package constructthelexicographicallylargestvalidsequence

// Time:  O(n!)
// Space: O(n)

class Solution {
    fun constructDistancedSequence(n: Int): IntArray {
        val result = IntArray(2 * n - 1)
        val lookup = BooleanArray(n + 1)
        backtracking(n, 0, lookup, result)
        return result
    }

    private fun backtracking(n: Int, i: Int, lookup: BooleanArray, result: IntArray): Boolean {
        if (i == result.size) {
            return true
        }
        if (result[i] != 0) {
            return backtracking(n, i + 1, lookup, result)
        }
        for (x in n downTo 1) {
            val j = if (x == 1) i else i + x
            if (lookup[x] || j >= result.size || result[j] != 0) {
                continue
            }
            result[i] = x
            result[j] = x
            lookup[x] = true
            if (backtracking(n, i + 1, lookup, result)) {
                return true
            }
            result[i] = 0
            result[j] = 0
            lookup[x] = false
        }
        return false
    }
}
