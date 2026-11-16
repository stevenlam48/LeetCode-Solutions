package maximumtotalrewardusingoperationsii

// Time:  O(nlogn + r^2), r = max(rewardValues)
// Space: O(r)

import java.util.BitSet

class Solution {
    fun maxTotalReward(rewardValues: IntArray): Int {
        val maxValue = 50000
        val sorted = rewardValues.toSet().sorted()
        val dp = BitSet(maxValue)
        val mask = BitSet(maxValue)
        dp.set(0)
        var j = 0
        for (i in 0 until sorted.size - 1) {
            while (j < sorted[i]) {
                mask.set(j++)
            }
            val available = dp.clone() as BitSet
            available.and(mask)
            var bit = available.nextSetBit(0)
            while (bit >= 0) {
                dp.set(bit + sorted[i])
                bit = available.nextSetBit(bit + 1)
            }
        }
        var result = sorted.last() - 1
        while (!dp[result]) {
            --result
        }
        return sorted.last() + result
    }
}
