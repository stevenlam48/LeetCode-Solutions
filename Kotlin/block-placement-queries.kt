package blockplacementqueries

import java.util.TreeSet

// Time:  O(qlogq)
// Space: O(q)

// bst, bit, fenwick tree
class Solution {
    fun getResults(queries: Array<IntArray>): List<Boolean> {
        val bst = TreeSet<Int>()
        for (q in queries) {
            if (q[0] == 1) {
                bst.add(q[1])
            }
        }
        val valToIdx = HashMap<Int, Int>()
        var i = 0
        for (x in bst) {
            valToIdx[x] = i++
        }

        val bit = BIT(valToIdx.size)
        var prev = 0
        for (x in bst) {
            bit.update(valToIdx[x]!!, (x - prev).toLong())
            prev = x
        }

        val result = mutableListOf<Boolean>()
        for (idx in queries.size - 1 downTo 0) {
            val x = queries[idx][1]
            if (queries[idx][0] == 1) {
                val next = bst.higher(x)
                if (next != null) {
                    val p = bst.lower(x) ?: 0
                    bit.update(valToIdx[next]!!, (next - p).toLong())
                }
                bst.remove(x)
            } else {
                val p = bst.lower(x)
                result.add(
                    x - (p ?: 0) >= queries[idx][2] ||
                        (p != null && bit.query(valToIdx[p]!!) >= queries[idx][2])
                )
            }
        }
        result.reverse()
        return result
    }

    private class BIT(n: Int) {
        private val bit = LongArray(n + 1)

        fun update(i0: Int, value: Long) {
            var i = i0 + 1
            while (i < bit.size) {
                bit[i] = maxOf(bit[i], value)
                i += i and -i
            }
        }

        fun query(i0: Int): Long {
            var i = i0 + 1
            var total = bit[0]
            while (i > 0) {
                total = maxOf(total, bit[i])
                i -= i and -i
            }
            return total
        }
    }
}
