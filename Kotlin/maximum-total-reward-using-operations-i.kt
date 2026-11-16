package maximumtotalrewardusingoperationsi
// Time:  O(nlogn + r^2), r = max(rewardValues)
// Space: O(r)

class Solution {
    fun maxTotalReward(rewardValues: IntArray): Int {
        val MAX_VALUE = 20000
        val sortedV = rewardValues.toSortedSet().toIntArray()
        val dp = BooleanArray(MAX_VALUE)
        val mask = BooleanArray(MAX_VALUE)
        dp[0] = true
        var j = 0
        for (i in 0 until sortedV.size - 1) {
            while (j < sortedV[i]) {
                mask[j++] = true
            }
            val v = sortedV[i]
            for (x in MAX_VALUE - 1 - v downTo 0) {
                if (dp[x] && mask[x]) {
                    dp[x + v] = true
                }
            }
        }
        var result = sortedV.last() - 1
        while (!dp[result]) {
            --result
        }
        return sortedV.last() + result
    }
}
