package minimumnumberofremovalstomakemountainarray

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun minimumMountainRemovals(nums: IntArray): Int {
        val leftLisLen = IntArray(nums.size)
        val lis = mutableListOf<Int>()
        for (i in 0 until nums.lastIndex) {
            val index = lowerBound(lis, nums[i])
            leftLisLen[i] = index
            if (index == lis.size) {
                lis.add(nums[i])
            } else {
                lis[index] = nums[i]
            }
        }
        lis.clear()
        var maxLen = 0
        for (i in nums.lastIndex downTo 1) {
            val index = lowerBound(lis, nums[i])
            maxLen = maxOf(maxLen, leftLisLen[i] + index)
            if (index == lis.size) {
                lis.add(nums[i])
            } else {
                lis[index] = nums[i]
            }
        }
        return nums.size - (1 + maxLen)
    }

    private fun lowerBound(nums: List<Int>, target: Int): Int {
        var left = 0
        var right = nums.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}
