package signoftheproductofanarray

// Time:  O(n)
// Space: O(1)
class Solution {
    fun arraySign(nums: IntArray): Int {
        var flag = 0
        for (x in nums) {
            if (x == 0) return 0
            if (x < 0) flag = flag xor 1
        }
        return if (flag % 2 != 0) -1 else 1
    }
}
