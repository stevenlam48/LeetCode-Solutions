package findthesubstringwithmaximumcost

// Time:  O(n)
// Space: O(1)

// greedy, kadane's algorithm
class Solution {
    fun maximumCostSubstring(s: String, chars: String, vals: IntArray): Int {
        val lookup = HashMap<Char, Int>()
        for (i in chars.indices) {
            lookup[chars[i]] = vals[i]
        }
        var result = 0
        var curr = 0
        for (c in s) {
            curr = maxOf(curr + (lookup[c] ?: (c - 'a' + 1)), 0)
            result = maxOf(result, curr)
        }
        return result
    }
}
