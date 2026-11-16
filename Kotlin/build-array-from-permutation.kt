package buildarrayfrompermutation

// Time:  O(n)
// Space: O(1)

class Solution {
    fun buildArray(nums: IntArray): IntArray {
        for (i in nums.indices) {
            var prev = i
            var curr = nums[i]
            while (curr >= 0 && curr != i) {
                val prevValue = nums[prev]
                val currValue = nums[curr]
                nums[prev] = currValue.inv()
                nums[curr] = if (prev == i) prevValue.inv() else prevValue
                val next = nums[prev].inv()
                prev = curr
                curr = next
            }
        }
        for (i in nums.indices) {
            if (nums[i] < 0) {
                nums[i] = nums[i].inv()
            }
        }
        return nums
    }
}
