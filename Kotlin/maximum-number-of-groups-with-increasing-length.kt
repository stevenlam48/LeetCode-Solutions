package maximumnumberofgroupswithincreasinglength
// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxIncreasingGroups(usageLimits: IntArray): Int {
        for (i in usageLimits.indices) {
            usageLimits[i] = minOf(usageLimits[i], usageLimits.size)
        }
        inplaceCountingSort(usageLimits, false)
        var result = 0
        var curr = 0L
        for (x in usageLimits) {
            curr += x
            if (curr >= result + 1) {
                curr -= result + 1
                ++result
            }
        }
        return result
    }

    private fun inplaceCountingSort(nums: IntArray, isReverse: Boolean) {
        if (nums.isEmpty()) {
            return
        }
        val maxNum = nums.max()
        val count = IntArray(maxNum + 1)
        for (num in nums) {
            ++count[num]
        }
        for (i in 1 until count.size) {
            count[i] += count[i - 1]
        }
        for (i in nums.indices.reversed()) {
            while (nums[i] >= 0) {
                --count[nums[i]]
                val j = count[nums[i]]
                val temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp.inv()
            }
        }
        for (i in nums.indices) {
            nums[i] = nums[i].inv()
        }
        if (isReverse) {
            nums.reverse()
        }
    }
}
