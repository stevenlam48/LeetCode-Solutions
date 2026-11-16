package majorityelement

// Time:  O(n)
// Space: O(1)

class Solution {
    fun majorityElement(nums: IntArray): Int {
        var result = 0
        var count = 0
        for (x in nums) {
            if (count == 0) {
                result = x
            }
            if (x == result) {
                ++count
            } else {
                --count
            }
        }
        return result
    }
}
