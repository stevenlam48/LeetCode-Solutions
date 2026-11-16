package maximumenergyboostfromtwodrinks

// Time:  O(n)
// Space: O(1)

// dp
class Solution {
    fun maxEnergyBoost(energyDrinkA: IntArray, energyDrinkB: IntArray): Long {
        var dp = longArrayOf(0L, 0L)
        for (i in energyDrinkA.indices) {
            val newDp = longArrayOf(0L, 0L)
            newDp[0] = maxOf(dp[0] + energyDrinkA[i], dp[1])
            newDp[1] = maxOf(dp[1] + energyDrinkB[i], dp[0])
            dp = newDp
        }
        return maxOf(dp[0], dp[1])
    }
}
