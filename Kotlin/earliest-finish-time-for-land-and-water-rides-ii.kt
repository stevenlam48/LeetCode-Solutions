package earliestfinishtimeforlandandwaterridesii

// Time:   O(n)
// Spacee: O(1)

// greedy
class Solution {
    fun earliestFinishTime(
        landStartTime: IntArray,
        landDuration: IntArray,
        waterStartTime: IntArray,
        waterDuration: IntArray
    ): Int {
        var mnLand = Int.MAX_VALUE
        for (i in landStartTime.indices) {
            mnLand = minOf(mnLand, landStartTime[i] + landDuration[i])
        }
        var mnWater = Int.MAX_VALUE
        for (i in waterStartTime.indices) {
            mnWater = minOf(mnWater, waterStartTime[i] + waterDuration[i])
        }
        var result = Int.MAX_VALUE
        for (i in landStartTime.indices) {
            result = minOf(result, maxOf(landStartTime[i], mnWater) + landDuration[i])
        }
        for (i in waterStartTime.indices) {
            result = minOf(result, maxOf(waterStartTime[i], mnLand) + waterDuration[i])
        }
        return result
    }
}
