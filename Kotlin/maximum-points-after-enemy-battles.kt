package maximumpointsafterenemybattles
// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumPoints(enemyEnergies: IntArray, currentEnergy: Int): Long {
        val minimum = enemyEnergies.minOrNull()!!
        return if (currentEnergy >= minimum) {
            (currentEnergy.toLong() - minimum + enemyEnergies.sumOf { it.toLong() }) / minimum
        } else {
            0L
        }
    }
}
