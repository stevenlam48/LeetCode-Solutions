package maximumproductofthreenumbers

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumProduct(nums: IntArray): Int {
        var min1 = Int.MAX_VALUE
        var min2 = Int.MAX_VALUE
        var max1 = Int.MIN_VALUE
        var max2 = Int.MIN_VALUE
        var max3 = Int.MIN_VALUE
        for (n in nums) {
            if (n <= min1) {
                min2 = min1
                min1 = n
            } else if (n <= min2) {
                min2 = n
            }
            if (n >= max1) {
                max3 = max2
                max2 = max1
                max1 = n
            } else if (n >= max2) {
                max3 = max2
                max2 = n
            } else if (n >= max3) {
                max3 = n
            }
        }
        return maxOf(min1 * min2 * max1, max1 * max2 * max3)
    }
}
