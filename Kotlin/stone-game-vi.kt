package stonegamevi

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun stoneGameVI(aliceValues: IntArray, bobValues: IntArray): Int {
        val sortedVals = aliceValues.indices
            .map { intArrayOf(aliceValues[it] + bobValues[it], aliceValues[it], bobValues[it]) }
            .sortedWith(
                compareByDescending<IntArray> { it[0] }
                    .thenByDescending { it[1] }
                    .thenByDescending { it[2] }
            )
        val result = IntArray(2)
        for (i in sortedVals.indices) {
            result[i % 2] += sortedVals[i][1 + i % 2]
        }
        return when {
            result[0] == result[1] -> 0
            result[0] > result[1] -> 1
            else -> -1
        }
    }
}
