package findindiceswithindexandvaluedifferenceii
// Time:  O(n)
// Space: O(1)

class Solution {
    fun findIndices(nums: IntArray, indexDifference: Int, valueDifference: Int): IntArray {
        var maxIndex = 0
        var minIndex = 0
        var i = 0
        while (i + indexDifference < nums.size) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i
            } else if (nums[i] < nums[minIndex]) {
                minIndex = i
            }
            if (nums[maxIndex] - nums[i + indexDifference] >= valueDifference) {
                return intArrayOf(maxIndex, i + indexDifference)
            }
            if (nums[i + indexDifference] - nums[minIndex] >= valueDifference) {
                return intArrayOf(minIndex, i + indexDifference)
            }
            ++i
        }
        return intArrayOf(-1, -1)
    }
}
