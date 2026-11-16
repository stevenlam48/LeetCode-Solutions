package alternatinggroupsiii

import java.util.TreeSet

// Time:  O(nlogn + qlogn)
// Space: O(n)

// sorted list, freq table, bit, fenwick tree
class Solution {
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

    fun numberOfAlternatingGroups(colors: IntArray, queries: Array<IntArray>): List<Int> {
        val n = colors.size
        val bst = TreeSet<Int>()
        val bit1 = BIT(n + 1)
        val bit2 = BIT(n + 1)

        fun update(i: Int, d: Int) {
            if (d == 1) {
                bst.add(i)
                if (bst.size == 1) {
                    bit1.add(n, +1)
                    bit2.add(n, +n)
                }
            }
            val prv = bst.lower(i) ?: bst.last()
            val nxt = bst.higher(i) ?: bst.first()
            if (bst.size != 1) {
                var l = ((nxt - prv) + (n - 1)) % n + 1
                bit1.add(l, d * -1)
                bit2.add(l, d * -l)
                l = ((i - prv) + n) % n
                bit1.add(l, d * +1)
                bit2.add(l, d * +l)
                l = ((nxt - i) + n) % n
                bit1.add(l, d * +1)
                bit2.add(l, d * +l)
            }
            if (d == -1) {
                if (bst.size == 1) {
                    bit1.add(n, -1)
                    bit2.add(n, -n)
                }
                bst.remove(i)
            }
        }

        val result = mutableListOf<Int>()
        for (i in 0 until n) {
            if (colors[i] == colors[(i + 1) % n]) {
                update(i, +1)
            }
        }
        for (q in queries) {
            if (q[0] == 1) {
                val l = q[1]
                result.add(
                    if (bst.isNotEmpty()) {
                        (bit2.query(n) - bit2.query(l - 1)) -
                            (l - 1) * (bit1.query(n) - bit1.query(l - 1))
                    } else {
                        n
                    }
                )
                continue
            }
            val i = q[1]
            if (colors[i] == q[2]) {
                continue
            }
            colors[i] = q[2]
            update((i - 1 + n) % n, if (colors[i] == colors[(i - 1 + n) % n]) +1 else -1)
            update(i, if (colors[i] == colors[(i + 1) % n]) +1 else -1)
        }
        return result
    }
}
