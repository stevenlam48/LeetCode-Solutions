package totaldistancetraveled

// Time:  O(1)
// Space: O(1)

class Solution {
    fun distanceTraveled(mainTank: Int, additionalTank: Int): Int {
        val use = 5
        val refill = 1
        val dist = 10
        val cnt = minOf((mainTank - refill) / (use - refill), additionalTank)
        return (mainTank + cnt * refill) * dist
    }
}
