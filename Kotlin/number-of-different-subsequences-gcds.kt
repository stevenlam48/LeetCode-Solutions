package numberofdifferentsubsequencesgcds

// Time:  O(n + m * (1 + 1/2 + 1/3 + ... + 1/m)) = O(n + mlogm), m is max of nums
// Space: O(n)

class Solution {
    fun countDifferentSubsequenceGCDs(nums: IntArray): Int {
        val numsSet = nums.toHashSet()
        val maxNum = nums.max()
        var result = 0
        for (i in 1..maxNum) {
            var d = 0
            var x = i
            while (x <= maxNum) {
                if (x in numsSet) {
                    d = gcd(d, x)
                    if (d == i) {
                        ++result
                        break
                    }
                }
                x += i
            }
        }
        return result
    }

    private fun gcd(a: Int, b: Int): Int {
        var a = a
        var b = b
        while (b != 0) {
            val tmp = b
            b = a % b
            a = tmp
        }
        return a
    }
}
