package maximumproductafterkincrements

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maximumProduct(nums: IntArray, k: Int): Int {
        val MOD = 1_000_000_007L
        nums.sort()
        var total = 0L
        for (x in nums) {
            total += x
        }
        var i = nums.size - 1
        while (i >= 0) {
            if (nums[i].toLong() * (i + 1) - total <= k) {
                break
            }
            total -= nums[i]
            --i
        }
        val q = (k + total) / (i + 1)
        val r = (k + total) % (i + 1)
        var result = powmod(q, (i + 1) - r, MOD) * powmod(q + 1, r, MOD) % MOD
        for (j in i + 1 until nums.size) {
            result = result * nums[j] % MOD
        }
        return result.toInt()
    }

    private fun powmod(a0: Long, b0: Long, mod: Long): Long {
        var a = a0 % mod
        var b = b0
        var result = 1L
        while (b > 0) {
            if (b and 1L == 1L) {
                result = result * a % mod
            }
            a = a * a % mod
            b = b shr 1
        }
        return result
    }
}
