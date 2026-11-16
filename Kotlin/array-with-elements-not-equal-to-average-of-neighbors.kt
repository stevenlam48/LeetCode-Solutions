package arraywithelementsnotequaltoaverageofneighbors

// Time:  O(n) ~ O(n^2), O(n) on average
// Space: O(1)

class Solution {
    fun rearrangeArray(nums: IntArray): IntArray {
        val mid = (nums.size - 1) / 2
        nums.sort()
        reversedTriPartitionWithVI(nums, nums[mid])
        return nums
    }

    private fun reversedTriPartitionWithVI(nums: IntArray, value: Int) {
        val N = nums.size / 2 * 2 + 1
        fun idx(i: Int): Int = (1 + 2 * i) % N
        var i = 0
        var j = 0
        var n = nums.size - 1
        while (j <= n) {
            if (nums[idx(j)] > value) {
                val a = idx(i)
                val b = idx(j)
                val tmp = nums[a]
                nums[a] = nums[b]
                nums[b] = tmp
                ++i
                ++j
            } else if (nums[idx(j)] < value) {
                val a = idx(j)
                val b = idx(n)
                val tmp = nums[a]
                nums[a] = nums[b]
                nums[b] = tmp
                --n
            } else {
                ++j
            }
        }
    }
}
