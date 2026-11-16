package maximumnumberofnonoverlappingsubarrayswithsumequalstarget
// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxNonOverlapping(nums: IntArray, target: Int): Int {
        val lookup = hashMapOf(0 to -1)
        var result = 0
        var accu = 0
        var right = -1
        for (i in nums.indices) {
            accu += nums[i]
            if (lookup.containsKey(accu - target) && lookup.getValue(accu - target) >= right) {
                right = i
                ++result
            }
            lookup[accu] = i
        }
        return result
    }
}
