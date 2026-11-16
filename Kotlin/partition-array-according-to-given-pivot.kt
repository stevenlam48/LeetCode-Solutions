package partitionarrayaccordingtogivenpivot

// Time:  O(n)
// Space: O(n)

// two pointers
class Solution {
    fun pivotArray(nums: IntArray, pivot: Int): IntArray {
        val result = IntArray(nums.size) { pivot }
        var left = 0
        var right = nums.size - nums.count { it > pivot }
        for (x in nums) {
            if (x < pivot) {
                result[left++] = x
            } else if (x > pivot) {
                result[right++] = x
            }
        }
        return result
    }
}
