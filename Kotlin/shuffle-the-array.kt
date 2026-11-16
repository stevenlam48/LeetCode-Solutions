package shufflethearray

// Time:  O(n)
// Space: O(1)
class Solution {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        fun index(i: Int): Int = if (i < n) 2 * i else 2 * (i - n) + 1
        for (i in nums.indices) {
            var j = i
            while (nums[i] >= 0) {
                j = index(j)
                val temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp.inv()
            }
        }
        for (i in nums.indices) {
            nums[i] = nums[i].inv()
        }
        return nums
    }
}
