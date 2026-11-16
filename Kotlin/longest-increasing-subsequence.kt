package longestincreasingsubsequence

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val LIS = mutableListOf<Int>()
        for (num in nums) {
            insert(LIS, num)
        }
        return LIS.size
    }

    private fun insert(LIS: MutableList<Int>, target: Int) {
        val index = LIS.binarySearch(target).let { if (it < 0) -it - 1 else it }
        if (index == LIS.size) {
            LIS.add(target)
        } else {
            LIS[index] = target
        }
    }
}
