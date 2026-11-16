package limitoccurrencesinsortedarray
// Time:  O(n)
// Space: O(1)

class Solution {
    fun limitOccurrences(nums: IntArray, k: Int): IntArray {
        var i = 0
        for (x in nums) {
            if (i - k >= 0 && nums[i - k] == x) {
                continue
            }
            nums[i++] = x
        }
        return nums.copyOf(i)
    }
}
