package maximumlengthofsubarraywithpositiveproduct

// Time:  O(n)
// Space: O(1)

class Solution {
    fun getMaxLen(nums: IntArray): Int {
        var result = 0
        var negativeCount = 0
        var lastZeroIndex = -1
        var firstValidNegativeIndex = -1
        for (i in nums.indices) {
            if (nums[i] == 0) {
                negativeCount = 0
                lastZeroIndex = i
                firstValidNegativeIndex = -1
                continue
            }
            if (nums[i] < 0) {
                if (firstValidNegativeIndex == -1) {
                    firstValidNegativeIndex = i
                }
                negativeCount++
            }
            val start = if (negativeCount % 2 == 0) lastZeroIndex else firstValidNegativeIndex
            result = maxOf(result, i - start)
        }
        return result
    }
}
