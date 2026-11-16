package countintegersappearinginasingleblock

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countSpecialIntegers(nums: IntArray): Int {
        var result = 0
        val cnt = HashMap<Int, Int>()
        for (i in nums.indices) {
            if (!(i + 1 == nums.size || nums[i + 1] != nums[i])) {
                continue
            }
            val count = cnt.getOrDefault(nums[i], 0)
            if (count == 0) {
                ++result
            } else if (count == 1) {
                --result
            }
            cnt[nums[i]] = count + 1
        }
        return result
    }
}
