package separatethedigitsinanarray

// Time:  O(n * logr)
// Space: O(1)

class Solution {
    fun separateDigits(nums: IntArray): IntArray {
        val result = ArrayList<Int>()
        for (i in nums.size - 1 downTo 0) {
            var x = nums[i]
            while (x != 0) {
                result.add(x % 10)
                x /= 10
            }
        }
        result.reverse()
        return result.toIntArray()
    }
}
