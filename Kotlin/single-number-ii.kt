package singlenumberii

// Time:  O(n)
// Space: O(1)
class Solution {
    fun singleNumber(nums: IntArray): Int {
        var one = 0
        var two = 0
        for (i in nums) {
            val newOne = (i.inv() and one) or (i and one.inv() and two.inv())
            val newTwo = (i.inv() and two) or (i and one)
            one = newOne
            two = newTwo
        }
        return one
    }
}
