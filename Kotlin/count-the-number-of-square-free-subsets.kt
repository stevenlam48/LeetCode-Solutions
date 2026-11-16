package countthenumberofsquarefreesubsets
// Time:  O(n + m * 2^p)
// Space: O(m * 2^p)

class Solution {
    fun squareFreeSubsets(nums: IntArray): Int {
        val maxNum = nums.max()
        fun linearSieveOfEratosthenes(n: Int): List<Int> {
            val spf = IntArray(n + 1) { -1 }
            val primes = mutableListOf<Int>()
            for (i in 2..n) {
                if (spf[i] == -1) {
                    spf[i] = i
                    primes.add(i)
                }
                for (p in primes) {
                    if (i * p > n || p > spf[i]) {
                        break
                    }
                    spf[i * p] = p
                }
            }
            return primes
        }

        val primes = linearSieveOfEratosthenes(maxNum)
        val masks = IntArray(maxNum + 1)
        for (x in 0..maxNum) {
            var y = x
            for (i in primes.indices) {
                if (y % primes[i] != 0) {
                    continue
                }
                if (y % (primes[i] * primes[i]) == 0) {
                    masks[x] = 0
                    break
                }
                masks[x] = masks[x] or (1 shl i)
                y /= primes[i]
            }
        }

        fun powMod(a: Int, b: Int): Long {
            var base = a % MOD
            var exp = b
            var result = 1L
            while (exp != 0) {
                if ((exp and 1) != 0) {
                    result = result * base % MOD
                }
                base = (base.toLong() * base % MOD).toInt()
                exp = exp shr 1
            }
            return result
        }

        val cnt = HashMap<Int, Int>()
        for (x in nums) {
            cnt[x] = cnt.getOrDefault(x, 0) + 1
        }
        val arr = cnt.keys.filter { it != 1 }
        val dp = IntArray(1 shl primes.size) { 1 }
        for (x in arr) {
            if (masks[x] == 0) {
                continue
            }
            for (mask in dp.lastIndex downTo 0) {
                if ((masks[x] and mask) == 0) {
                    val newMask = mask or masks[x]
                    dp[newMask] = ((dp[newMask] + cnt.getValue(x).toLong() * dp[mask]) % MOD).toInt()
                }
            }
        }
        return if (cnt.containsKey(1)) {
            ((dp.last() * powMod(2, cnt.getValue(1)) - 1 + MOD) % MOD).toInt()
        } else {
            (dp.last() - 1 + MOD) % MOD
        }
    }

    companion object {
        private const val MOD = 1_000_000_007
    }
}
