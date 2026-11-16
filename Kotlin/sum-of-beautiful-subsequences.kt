package sumofbeautifulsubsequences

// Time:  precompute: O(rlogr), r = max_nums
//        runtime:    O(mx + nlogr * (log(nlogr) + logn)), mx = max(nums)
// Space: O(rlogr)
private const val MOD = 1_000_000_007
private const val MAX_NUM = 7 * 10000

private class BIT(n: Int) {
    private val bit = IntArray(n + 1)

    fun add(i: Int, value: Int) {
        var index = i + 1
        while (index < bit.size) {
            bit[index] = (bit[index] + value) % MOD
            index += lowerBit(index)
        }
    }

    fun query(i: Int): Int {
        var index = i + 1
        var total = 0
        while (index > 0) {
            total = (total + bit[index]) % MOD
            index -= lowerBit(index)
        }
        return total
    }

    private fun lowerBit(i: Int): Int {
        return i and -i
    }
}

private fun factors(n: Int): Array<MutableList<Int>> {
    val result = Array(n + 1) { mutableListOf<Int>() }
    for (i in 1..n) {
        var j = i
        while (j <= n) {
            result[j].add(i)
            j += i
        }
    }
    return result
}

private fun phiSieve(n: Int): IntArray {
    val phi = IntArray(n + 1) { it }
    for (i in 2..n) {
        if (phi[i] != i) {
            continue
        }
        for (j in i..n step i) {
            phi[j] -= phi[j] / i
        }
    }
    return phi
}

private val FACTORS = factors(MAX_NUM)
private val PHI = phiSieve(MAX_NUM)

class Solution {
    fun totalBeauty(nums: IntArray): Int {
        val mx = nums.max()
        val valToIdx = IntArray(mx + 1)
        fun count(arr: List<Int>): Int {
            val sortedArr = arr.sorted()
            for (i in sortedArr.indices) {
                valToIdx[sortedArr[i]] = i
            }
            val bit = BIT(arr.size)
            for (x in arr) {
                val index = valToIdx[x]
                bit.add(index, bit.query(index - 1) + 1)
            }
            return bit.query(arr.size - 1)
        }

        val lookup = Array(mx + 1) { mutableListOf<Int>() }
        for (x in nums) {
            for (d in FACTORS[x]) {
                lookup[d].add(x)
            }
        }
        var result = 0
        for (g in mx downTo 1) {
            result = (result + PHI[g].toLong() * count(lookup[g]) % MOD).toInt() % MOD
        }
        return result
    }
}
