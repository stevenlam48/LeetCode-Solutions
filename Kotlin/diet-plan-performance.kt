package dietplanperformance

// Time:  O(n)
// Space: O(1)

class Solution {
    fun dietPlanPerformance(calories: IntArray, k: Int, lower: Int, upper: Int): Int {
        var total = 0
        for (i in 0 until k) {
            total += calories[i]
        }
        var result = (if (total > upper) 1 else 0) - (if (total < lower) 1 else 0)
        for (i in k until calories.size) {
            total += calories[i] - calories[i - k]
            result += (if (total > upper) 1 else 0) - (if (total < lower) 1 else 0)
        }
        return result
    }
}
