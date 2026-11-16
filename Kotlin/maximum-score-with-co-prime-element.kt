package maximumscorewithcoprimeelement

// Time:  O(n + rlogr)
// Space: O(r)

class Solution {
    fun maxScore(nums: IntArray, maxVal: Int): Int {
        val mx = maxOf(nums.max(), maxVal)
        val spf = IntArray(mx + 1) { -1 }
        val primes = ArrayList<Int>()
        for (i in 2..mx) {
            if (spf[i] == -1) {
                spf[i] = i
                primes.add(i)
            }
            for (p in primes) {
                if (i * p > mx || p > spf[i]) {
                    break
                }
                spf[i * p] = p
            }
        }
        val mu = IntArray(mx + 1)
        for (i in 1..mx) {
            mu[i] = if (i == 1) 1 else if (spf[i / spf[i]] == spf[i]) 0 else -mu[i / spf[i]]
        }
        val cnt = IntArray(mx + 1)
        for (x in nums) {
            cnt[x]++
        }
        val multipleCnt = IntArray(mx + 1)
        for (i in 1..mx) {
            var j = i
            while (j <= mx) {
                multipleCnt[i] += cnt[j]
                j += i
            }
        }
        val coprimeCnt = IntArray(mx + 1)
        for (i in 1..mx) {
            if (mu[i] * multipleCnt[i] == 0) {
                continue
            }
            var j = i
            while (j <= mx) {
                coprimeCnt[j] += mu[i] * multipleCnt[i]
                j += i
            }
        }
        var result = 0
        for (i in 1..mx) {
            val c = nums.size - coprimeCnt[i]
            if (cnt[i] > 0) {
                result = maxOf(result, i - (if (i != 1) c - 1 else 0))
            } else if (i <= maxVal) {
                result = maxOf(result, i - maxOf(c, 1))
            }
        }
        return result
    }
}
