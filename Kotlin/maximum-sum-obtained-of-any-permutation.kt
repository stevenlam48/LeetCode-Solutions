package maximumsumobtainedofanypermutation
// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun maxSumRangeQuery(nums: IntArray, requests: Array<IntArray>): Int {
        val count = IntArray(nums.size)
        for (req in requests) {
            ++count[req[0]]
            if (req[1] + 1 < count.size) {
                --count[req[1] + 1]
            }
        }
        for (i in 1 until count.size) {
            count[i] += count[i - 1]
        }
        nums.sort()
        count.sort()
        var result = 0
        for (i in nums.indices) {
            result = addmod(
                result.toLong(),
                mulmod(nums[i].toLong(), count[i].toLong(), MOD.toLong()),
                MOD.toLong()
            ).toInt()
        }
        return result
    }

    private fun addmod(a: Long, b: Long, mod: Long): Long {
        var x = a % mod
        var y = b % mod
        if (mod - x <= y) {
            y -= mod
        }
        return x + y
    }

    private fun mulmod(a: Long, b: Long, mod: Long): Long {
        var x = a % mod
        var y = b % mod
        var result = 0L
        if (x < y) {
            val temp = x
            x = y
            y = temp
        }
        while (y > 0) {
            if (y % 2 == 1L) {
                result = addmod(result, x, mod)
            }
            x = addmod(x, x, mod)
            y /= 2
        }
        return result
    }

    companion object {
        private const val MOD = 1_000_000_007
    }
}
