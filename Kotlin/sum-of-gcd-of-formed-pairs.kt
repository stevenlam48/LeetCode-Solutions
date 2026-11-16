package sumofgcdofformedpairs

// Time:  O(nlogr)
// Space: O(n)

// prefix sum, sort, two pointers
class Solution {
    fun gcdSum(nums: IntArray): Long {
        val prefix = IntArray(nums.size)
        var mx = 0
        for (i in nums.indices) {
            mx = maxOf(mx, nums[i])
            prefix[i] = gcd(mx, nums[i])
        }
        prefix.sort()
        var result = 0L
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            result += gcd(prefix[left], prefix[right])
            ++left
            --right
        }
        return result
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val t = x % y
            x = y
            y = t
        }
        return x
    }
}
