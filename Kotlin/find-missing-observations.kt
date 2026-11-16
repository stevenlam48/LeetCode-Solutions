package findmissingobservations

// Time:  O(n)
// Space: O(1)

class Solution {
    fun missingRolls(rolls: IntArray, mean: Int, n: Int): IntArray {
        val maxV = 6
        val minV = 1
        val total = rolls.sum()
        val missing = mean * (n + rolls.size) - total
        if (missing < minV * n || missing > maxV * n) {
            return intArrayOf()
        }
        val q = missing / n
        val r = missing % n
        val result = IntArray(n)
        for (i in result.indices) {
            result[i] = q + if (i < r) 1 else 0
        }
        return result
    }
}
