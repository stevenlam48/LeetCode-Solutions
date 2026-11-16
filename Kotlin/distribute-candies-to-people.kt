package distributecandiestopeople
// Time:  O(n + logc), c is the number of candies
// Space: O(1)

import kotlin.math.sqrt

class Solution {
    fun distributeCandies(candies: Int, numPeople: Int): IntArray {
        val p = (sqrt(2 * candies + 0.25) - 0.5).toInt()
        val remaining = candies - (p + 1) * p / 2
        val rows = p / numPeople
        val cols = p % numPeople
        val result = IntArray(numPeople)
        for (i in 0 until numPeople) {
            result[i] = if (i < cols) {
                (i + 1) * (rows + 1) + rows * (rows + 1) / 2 * numPeople
            } else {
                (i + 1) * rows + (rows - 1) * rows / 2 * numPeople
            }
        }
        result[cols] += remaining
        return result
    }
}
