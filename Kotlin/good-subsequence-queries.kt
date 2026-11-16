package goodsubsequencequeries

// Time:  precompute: O(rlog(logr))
//        runtime:    O(r + (n + q) * log(logr))
// Space: O(rlog(logr) + n)

private const val MAX_NUMS = 50000

private fun precompute(r: Int): Pair<Array<MutableList<Int>>, Int> {
    val factors = Array(r + 1) { mutableListOf<Int>() }
    var curr = 1
    var k = 0
    for (i in 2 until factors.size) {
        if (factors[i].isNotEmpty()) {
            continue
        }
        if (curr * i <= r) {
            curr *= i
            k++
        }
        for (j in i until factors.size step i) {
            factors[j].add(i)
        }
    }
    return factors to k
}

private val factorsAndK = precompute(MAX_NUMS)
private val FACTORS = factorsAndK.first
private val K = factorsAndK.second

class Solution {
    fun countGoodSubseq(nums: IntArray, p: Int, queries: Array<IntArray>): Int {
        if (nums.size == 1) {
            return 0
        }
        var curr = 0
        var mx = nums.max()
        for (q in queries) {
            mx = maxOf(mx, q[1])
        }
        val cnt = IntArray(mx + 1)
        val cnt2 = IntArray(nums.size + 1)

        fun update(x: Int, d: Int) {
            if (x % p != 0) {
                return
            }
            for (q in FACTORS[x / p]) {
                cnt2[cnt[q]]--
                cnt[q] += d
                cnt2[cnt[q]]++
            }
            curr += d
        }

        fun check(): Boolean {
            if (curr == 0 || cnt2[curr] != 0) {
                return false
            }
            if (curr != nums.size || nums.size > K) {
                return true
            }
            for (i in nums.indices) {
                update(nums[i], -1)
                val found = cnt2[curr] == 0
                update(nums[i], 1)
                if (found) {
                    return true
                }
            }
            return false
        }

        var result = 0
        for (x in nums) {
            update(x, 1)
        }
        for (q in queries) {
            val i = q[0]
            val x = q[1]
            update(nums[i], -1)
            nums[i] = x
            update(nums[i], 1)
            if (check()) {
                result++
            }
        }
        return result
    }
}
