package countarraypairsdivisiblebyk

// Time:  O(nlogk + sqrt(k)^2) = O(nlogk + k)
// Space: O(sqrt(k)), number of factors of k is at most sqrt(k)

class Solution {
    fun countPairs(nums: IntArray, k: Int): Long {
        val cnt = HashMap<Long, Long>()
        for (x in nums) {
            val g = gcd(x.toLong(), k.toLong())
            cnt[g] = (cnt[g] ?: 0L) + 1
        }
        var result = 0L
        for ((x, c1) in cnt) {
            for ((y, c2) in cnt) {
                if (x > y || x * y % k != 0L) {
                    continue
                }
                result += if (x != y) c1 * c2 else c1 * (c1 - 1) / 2
            }
        }
        return result
    }

    private fun gcd(a: Long, b: Long): Long {
        var x = a
        var y = b
        while (y != 0L) {
            val t = x % y
            x = y
            y = t
        }
        return x
    }
}
