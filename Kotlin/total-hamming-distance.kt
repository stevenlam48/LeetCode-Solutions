package totalhammingdistance

// Time:  O(n)
// Space: O(1)

class Solution {
    fun totalHammingDistance(nums: IntArray): Int {
        var result = 0
        for (i in 0 until 32) {
            val counts = IntArray(2)
            for (num in nums) {
                ++counts[(num ushr i) and 1]
            }
            result += counts[0] * counts[1]
        }
        return result
    }
}
