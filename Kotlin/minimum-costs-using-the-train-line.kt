package minimumcostsusingthetrainline

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumCosts(regular: IntArray, express: IntArray, expressCost: Int): LongArray {
        val result = LongArray(regular.size)
        var dp0 = 0L
        var dp1 = expressCost.toLong()
        for (i in regular.indices) {
            val next0 = minOf(dp0 + regular[i], dp1 + express[i])
            val next1 = minOf(dp0 + regular[i] + expressCost, dp1 + express[i])
            dp0 = next0
            dp1 = next1
            result[i] = minOf(dp0, dp1)
        }
        return result
    }
}
