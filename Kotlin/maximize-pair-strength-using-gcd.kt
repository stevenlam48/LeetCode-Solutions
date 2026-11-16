package maximizepairstrengthusinggcd

// Time:  O(n^2 * logr)
// Space: O(1)

class Solution {
    fun maxPairStrength(nums: IntArray): Long {
        nums.sortDescending()
        var result = 0L
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i].toLong() * nums[j] <= result) {
                    break
                }
                val g = gcd(nums[i], nums[j]).toLong()
                result = maxOf(result, (nums[i] / g) * (nums[j] / g))
            }
        }
        return result
    }
}

private tailrec fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}
