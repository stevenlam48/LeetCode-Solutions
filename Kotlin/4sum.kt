package p4sum

// Time:  O(n^3)
// Space: O(1)

class Solution {
    fun fourSum(nums: IntArray, target: Int): Array<IntArray> {
        nums.sort()
        val result = ArrayList<IntArray>()
        for (i in 0 until nums.size - 3) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }
            for (j in i + 1 until nums.size - 2) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue
                }
                val total = target - nums[i] - nums[j]
                var left = j + 1
                var right = nums.size - 1
                while (left < right) {
                    if (nums[left] + nums[right] == total) {
                        result.add(intArrayOf(nums[i], nums[j], nums[left], nums[right]))
                        ++left
                        --right
                        while (left < right && nums[left] == nums[left - 1]) {
                            ++left
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            --right
                        }
                    } else {
                        if (nums[left] + nums[right] > total) {
                            --right
                        } else {
                            ++left
                        }
                    }
                }
            }
        }
        return result.toTypedArray()
    }
}
