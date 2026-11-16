package maximumproductoftwoelementsinanarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxProduct(nums: IntArray): Int {
        var m1 = 0
        var m2 = 0
        for (num in nums) {
            if (num > m1) {
                m2 = m1
                m1 = num
            } else if (num > m2) {
                m2 = num
            }
        }
        return (m1 - 1) * (m2 - 1)
    }
}
