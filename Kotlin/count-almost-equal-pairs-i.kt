package countalmostequalpairsi

// Time:  O(n * l^2)
// Space: O(n)

class Solution {
    fun countPairs(nums: IntArray): Int {
        val L = 7
        val POW10 = IntArray(L)
        POW10[0] = 1
        for (i in 0 until L - 1) {
            POW10[i + 1] = POW10[i] * 10
        }
        val cnt1 = HashMap<Int, Int>()
        for (x in nums) {
            cnt1[x] = (cnt1[x] ?: 0) + 1
        }
        val cnt2 = HashMap<Int, Int>()
        for ((x, v) in cnt1) {
            for (i in 0 until L) {
                val a = x / POW10[i] % 10
                for (j in i + 1 until L) {
                    val b = x / POW10[j] % 10
                    if (a == b) {
                        continue
                    }
                    val y = x - a * (POW10[i] - POW10[j]) + b * (POW10[i] - POW10[j])
                    if (!cnt1.containsKey(y)) {
                        continue
                    }
                    cnt2[y] = (cnt2[y] ?: 0) + v
                }
            }
        }
        var result = 0
        for ((_, v) in cnt1) {
            result += v * (v - 1) / 2
        }
        var total = 0
        for ((x, v) in cnt1) {
            total += v * (cnt2[x] ?: 0)
        }
        return result + total / 2
    }
}
