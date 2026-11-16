package smallestmissingintegergreaterthansequentialprefixsum

// Time:  O(n)
// Space: O(n)

class Solution {
    fun missingInteger(nums: IntArray): Int {
        var total = nums[0]
        for (i in 1 until nums.size) {
            if (nums[i] != nums[i - 1] + 1) {
                break
            }
            total += nums[i]
        }
        val lookup = nums.toHashSet()
        while (lookup.contains(total)) {
            ++total
        }
        return total
    }
}
