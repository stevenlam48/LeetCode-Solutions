package inversecoinchange

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun findCoins(numWays: IntArray): IntArray {
        val result = mutableListOf<Int>()
        for (i in 1..numWays.size) {
            if (numWays[i - 1] == 1) {
                result.add(i)
                for (j in numWays.size downTo i) {
                    numWays[j - 1] -= if ((j - i) - 1 >= 0) numWays[(j - i) - 1] else 1
                }
            }
            if (numWays[i - 1] != 0) {
                return intArrayOf()
            }
        }
        return result.toIntArray()
    }
}
