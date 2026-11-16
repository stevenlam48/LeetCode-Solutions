package intersectionofmultiplearrays
// Time:  O(n * l + r), n = len(nums), l = len(nums[0])
// Space: O(r), r = max(nums)-min(nums)

class Solution {
    fun intersection(nums: Array<IntArray>): IntArray {
        val counts = IntArray(1001)
        for (array in nums) {
            for (value in array) {
                ++counts[value]
            }
        }
        val result = mutableListOf<Int>()
        for (i in 1..1000) {
            if (counts[i] == nums.size) {
                result.add(i)
            }
        }
        return result.toIntArray()
    }
}
