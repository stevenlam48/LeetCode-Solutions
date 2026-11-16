package maximizehappinessofselectedchildren

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
        happiness.sortDescending()
        var result = 0L
        for (i in 0 until k) {
            if (happiness[i] - i <= 0) {
                break
            }
            result += (happiness[i] - i).toLong()
        }
        return result
    }
}
