package checkifbitwiseorhastrailingzeros

// Time:  O(n)
// Space: O(1)

class Solution {
    fun hasTrailingZeros(nums: IntArray): Boolean {
        var cnt = 0
        for (x in nums) {
            if (x % 2 != 0) {
                continue
            }
            if (++cnt == 2) {
                return true
            }
        }
        return false
    }
}
