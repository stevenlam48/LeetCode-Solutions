package numberofintegerswithpopcountdepthequaltokii

// Time:  precompute: O((logr) * log(logr) + log*(r) * (logr)) = O((logr) * log(logr)), r = max(n)
//        runtime:    O(nlogr + max_k * n + nlogn + qlogn)
// Space: O(logr + max_k * n)

// fenwick tree
private class BIT(n: Int) {
    private val bit = IntArray(n + 1)

    fun add(i0: Int, value: Int) {
        var i = i0 + 1
        while (i < bit.size) {
            bit[i] += value
            i += i and -i
        }
    }

    fun query(i0: Int): Int {
        var i = i0 + 1
        var total = 0
        while (i > 0) {
            total += bit[i]
            i -= i and -i
        }
        return total
    }
}

private fun bitLength(x: Long): Int = if (x != 0L) 64 - java.lang.Long.numberOfLeadingZeros(x) else 0

private fun ceilLog2(x: Long): Int = bitLength(x - 1)

private const val MAX_N = 1_000_000_000_000_000L
private val MAX_BIT_LEN = bitLength(MAX_N)

private val D: IntArray = IntArray(MAX_BIT_LEN + 1).also { d ->
    for (i in 2 until d.size) {
        d[i] = d[Integer.bitCount(i)] + 1
    }
}

private val MAX_K: Int = run {
    var x = MAX_N
    var k = 0
    while (x != 1L) {
        x = ceilLog2(x).toLong()
        ++k
    }
    k
}

class Solution {
    fun popcountDepth(nums: LongArray, queries: Array<LongArray>): IntArray {
        fun count(x: Long): Int = if (x != 1L) D[java.lang.Long.bitCount(x)] + 1 else 0

        val bit = Array(MAX_K + 1) { BIT(nums.size) }
        for (i in nums.indices) {
            bit[count(nums[i])].add(i, 1)
        }
        val result = ArrayList<Int>()
        for (q in queries) {
            if (q[0] == 1L) {
                val l = q[1].toInt()
                val r = q[2].toInt()
                val k = q[3].toInt()
                result.add(bit[k].query(r) - bit[k].query(l - 1))
            } else {
                val i = q[1].toInt()
                val x = q[2]
                val oldD = count(nums[i])
                val newD = count(x)
                if (newD != oldD) {
                    bit[oldD].add(i, -1)
                    bit[newD].add(i, 1)
                }
                nums[i] = x
            }
        }
        return result.toIntArray()
    }
}
