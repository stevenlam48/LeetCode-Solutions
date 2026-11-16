package wigglesortii

// Time:  O(n) ~ O(n^2), O(n) on average.
// Space: O(1)

// Tri Partition (aka Dutch National Flag Problem) with virtual index solution. (44ms)
class Solution {
    fun wiggleSort(nums: IntArray) {
        val mid = (nums.size - 1) / 2
        nums.sort()
        reversedTriPartitionWithVI(nums, nums[mid])
    }

    fun reversedTriPartitionWithVI(nums: IntArray, value: Int) {
        val mod = nums.size / 2 * 2 + 1
        fun at(i: Int) = (1 + 2 * i) % mod
        var i = 0
        var j = 0
        var n = nums.size - 1
        while (j <= n) {
            if (nums[at(j)] > value) {
                swap(nums, at(i++), at(j++))
            } else if (nums[at(j)] < value) {
                swap(nums, at(j), at(n--))
            } else {
                ++j
            }
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val tmp = nums[i]
        nums[i] = nums[j]
        nums[j] = tmp
    }
}
