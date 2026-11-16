package canyoueatyourfavoritecandyonyourfavoriteday

// Time:  O(n)
// Space: O(n)

class Solution {
    fun canEat(candiesCount: IntArray, queries: Array<IntArray>): List<Boolean> {
        val prefix = LongArray(candiesCount.size + 1)
        for (i in candiesCount.indices) {
            prefix[i + 1] = prefix[i] + candiesCount[i]
        }
        val result = mutableListOf<Boolean>()
        for (q in queries) {
            result.add(prefix[q[0]] / q[2] < q[1] + 1 && q[1] + 1 <= prefix[q[0] + 1] / 1)
        }
        return result
    }
}
