package specialarraywithxelementsgreaterthanorequalx

// Time:  O(n)
// Space: O(1)

class Solution {
    fun specialArray(nums: IntArray): Int {
        val MAX_NUM = 1000
        val count = IntArray(MAX_NUM + 1)
        for (num in nums) {
            ++count[num]
        }
        var n = nums.size
        var i = 0
        while (i < count.size) {
            if (i == n) {
                return i
            }
            n -= count[i]
            ++i
        }
        return -1
    }
}
