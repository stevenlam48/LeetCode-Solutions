package maximumproductdifferencebetweentwopairs

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxProductDifference(nums: IntArray): Int {
        var largest0 = 0
        var largest1 = 0
        var smallest0 = Int.MAX_VALUE
        var smallest1 = Int.MAX_VALUE
        for (x in nums) {
            if (x >= largest0) {
                largest1 = largest0
                largest0 = x
            } else if (x > largest1) {
                largest1 = x
            }
            if (x <= smallest0) {
                smallest1 = smallest0
                smallest0 = x
            } else if (x < smallest1) {
                smallest1 = x
            }
        }
        return largest0 * largest1 - smallest0 * smallest1
    }
}
