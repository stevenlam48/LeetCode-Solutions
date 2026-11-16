package countnondecreasingarrayswithgivendigitsums

// Time:  precompute: O(rlogr)
//        runtime:    O(n * r)
// Space: O(r)

// dp, prefix sum
class Solution {
    fun countArrays(digitSum: IntArray): Int {
        var dp = mutableListOf(0 to 1)
        for (x in digitSum) {
            val newDp = mutableListOf<Pair<Int, Int>>()
            var prefix = 0
            var i = 0
            for (v in LOOKUP[x]) {
                while (i < dp.size) {
                    if (dp[i].first > v) {
                        break
                    }
                    prefix = (prefix + dp[i].second) % MOD
                    ++i
                }
                if (prefix != 0) {
                    newDp.add(v to prefix)
                }
            }
            dp = newDp
        }
        var result = 0
        for ((_, c) in dp) {
            result = (result + c) % MOD
        }
        return result
    }

    companion object {
        private const val MOD = 1_000_000_007
        private const val R = 5000
        private val LOOKUP: Array<MutableList<Int>> = run {
            val lookup = Array(R + 1) { mutableListOf<Int>() }
            for (i in 0..R) {
                lookup[total(i)].add(i)
            }
            lookup
        }

        private fun total(x0: Int): Int {
            var x = x0
            var result = 0
            while (x != 0) {
                result += x % 10
                x /= 10
            }
            return result
        }
    }
}
