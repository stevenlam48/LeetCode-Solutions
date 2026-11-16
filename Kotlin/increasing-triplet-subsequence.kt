package increasingtripletsubsequence

// Time:  O(n)
// Space: O(1)

class Solution {
    fun increasingTriplet(nums: IntArray): Boolean {
        var min = Int.MAX_VALUE
        var a = Int.MAX_VALUE
        var b = Int.MAX_VALUE
        for (c in nums) {
            if (min >= c) {
                min = c
            } else if (b >= c) {
                a = min
                b = c
            } else {  // a < b < c
                return true
            }
        }
        return false
    }
}
