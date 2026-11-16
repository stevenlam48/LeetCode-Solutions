package maximumabsolutesumofanysubarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxAbsoluteSum(nums: IntArray): Int {
        var curr = 0
        var mx = 0
        var mn = 0
        for (num in nums) {
            curr += num
            mx = maxOf(mx, curr)
            mn = minOf(mn, curr)
        }
        return mx - mn
    }
}
