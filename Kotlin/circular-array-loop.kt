package circulararrayloop

// Time:  O(n)
// Space: O(1)

class Solution {
    fun circularArrayLoop(nums: IntArray): Boolean {
        for (i in nums.indices) {
            if (nums[i] == 0) {
                continue
            }
            var slow = i
            var fast = i
            while (
                nums[next(nums, slow)] * nums[i] > 0 &&
                nums[next(nums, fast)] * nums[i] > 0 &&
                nums[next(nums, next(nums, fast))] * nums[i] > 0
            ) {
                slow = next(nums, slow)
                fast = next(nums, next(nums, fast))
                if (slow == fast) {
                    if (slow == next(nums, slow)) {
                        break
                    }
                    return true
                }
            }
            slow = i
            val value = nums[i]
            while (nums[slow] * value > 0) {
                val tmp = next(nums, slow)
                nums[slow] = 0
                slow = tmp
            }
        }
        return false
    }

    private fun next(nums: IntArray, i: Int): Int {
        return ((i + nums[i]) + nums.size) % nums.size
    }
}
