package addminimumnumberofrungs

// Time:  O(n)
// Space: O(1)

class Solution {
    fun addRungs(rungs: IntArray, dist: Int): Int {
        var result = 0
        var prev = 0
        for (curr in rungs) {
            result += ceilDivide(curr - prev, dist) - 1
            prev = curr
        }
        return result
    }

    private fun ceilDivide(a: Int, b: Int): Int {
        return (a + (b - 1)) / b
    }
}
