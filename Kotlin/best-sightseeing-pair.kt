package bestsightseeingpair

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxScoreSightseeingPair(A: IntArray): Int {
        var result = 0
        var curr = 0
        for (x in A) {
            result = kotlin.math.max(result, curr + x)
            curr = kotlin.math.max(curr, x) - 1
        }
        return result
    }
}
