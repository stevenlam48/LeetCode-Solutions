package checkifitisagoodarray

// Time:  O(n)
// Space: O(1)
class Solution {
    fun isGoodArray(nums: IntArray): Boolean {
        var result = nums[0]
        for (num in nums) {
            result = gcd(result, num)
            if (result == 1) {
                break
            }
        }
        return result == 1
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val remainder = x % y
            x = y
            y = remainder
        }
        return if (x < 0) -x else x
    }
}
