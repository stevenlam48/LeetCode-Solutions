package howmanynumbersaresmallerthanthecurrentnumber
// Time:  O(n + m), m is the max number of nums
// Space: O(m)

class Solution {
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val m = nums.max()
        val count = counter(nums)
        for (i in 0..m) {
            count[i] = (count[i] ?: 0) + (count[i - 1] ?: 0)
        }
        val result = mutableListOf<Int>()
        for (i in nums) {
            result.add(count[i - 1] ?: 0)
        }
        return result.toIntArray()
    }

    private fun counter(nums: IntArray): HashMap<Int, Int> {
        val count = HashMap<Int, Int>()
        for (num in nums) {
            count[num] = (count[num] ?: 0) + 1
        }
        return count
    }
}
