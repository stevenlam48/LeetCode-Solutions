package findthemaximumfactorscoreofarray
// Time:  O(nlogr)
// Space: O(n)

class Solution {
    fun maxScore(nums: IntArray): Long {
        val right1 = LongArray(nums.size + 1)
        val right2 = LongArray(nums.size + 1)
        right2[nums.size] = 1
        for (i in nums.indices.reversed()) {
            right1[i] = gcd(right1[i + 1], nums[i].toLong())
            right2[i] = lcm(right2[i + 1], nums[i].toLong())
        }
        var result = right1[0] * right2[0]
        var curr1 = 0L
        var curr2 = 1L
        for (i in nums.indices) {
            result = maxOf(result, gcd(curr1, right1[i + 1]) * lcm(curr2, right2[i + 1]))
            curr1 = gcd(curr1, nums[i].toLong())
            curr2 = lcm(curr2, nums[i].toLong())
        }
        return result
    }

    private fun gcd(a: Long, b: Long): Long {
        var x = a
        var y = b
        while (y != 0L) {
            val remainder = x % y
            x = y
            y = remainder
        }
        return x
    }

    private fun lcm(a: Long, b: Long): Long {
        return if (a == 0L || b == 0L) 0L else a / gcd(a, b) * b
    }
}
