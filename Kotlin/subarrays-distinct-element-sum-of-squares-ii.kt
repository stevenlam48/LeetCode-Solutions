package subarraysdistinctelementsumofsquaresii

// Time:  O(nlogn)
// Space: O(n)

// bit, fenwick tree, ordered set, math
class Solution {
    fun sumCounts(nums: IntArray): Int {
        val n = nums.size
        val os = OrderedSet(n)
        val idxs = HashMap<Int, MutableList<Int>>()
        for (i in n - 1 downTo 0) {
            idxs.getOrPut(nums[i]) { mutableListOf() }.add(i)
        }
        val initial = idxs.values.map { it.last() }.sorted()
        for (x in initial) {
            os.insert(x)
        }
        var result = 0L
        var accu = (n.toLong() * os.size() % MOD) * os.size() % MOD
        for (i in 0 until os.size()) {
            accu = ((accu - (2L * i + 1) * os.findByOrder(i) % MOD) % MOD + MOD) % MOD
        }
        val bit = BIT(n)
        for (x in initial) {
            bit.add(x, x)
        }

        fun update(x: Int, accuIn: Long, d: Int): Long {
            val idx = idxs[x]!!.last()
            val i = os.orderOfKey(idx)
            var accu = accuIn
            accu = ((accu + d * (n.toLong() * (2 * os.size() - 1)
                - (2L * i + 1) * idx
                - 2L * (bit.query(n - 1) - bit.query(idx)))) % MOD + MOD) % MOD
            bit.add(idx, d * idx)
            return accu
        }

        for (x in nums) {
            result = (result + accu) % MOD
            accu = update(x, accu, -1)
            os.erase(idxs[x]!!.last())
            idxs[x]!!.removeAt(idxs[x]!!.size - 1)
            if (idxs[x]!!.isEmpty()) {
                continue
            }
            os.insert(idxs[x]!!.last())
            accu = update(x, accu, 1)
        }
        return result.toInt()
    }

    private class OrderedSet(private val n: Int) {
        private val bit = IntArray(n + 1)
        private var sz = 0

        fun size(): Int = sz

        fun insert(x: Int) {
            if (contains(x)) {
                return
            }
            add(x, 1)
            ++sz
        }

        fun erase(x: Int) {
            if (!contains(x)) {
                return
            }
            add(x, -1)
            --sz
        }

        fun orderOfKey(x: Int): Int = prefix(x)

        fun findByOrder(k: Int): Int {
            var idx = 0
            var bitMask = Integer.highestOneBit(n)
            var remaining = k
            while (bitMask != 0) {
                val next = idx + bitMask
                if (next <= n && bit[next] <= remaining) {
                    idx = next
                    remaining -= bit[next]
                }
                bitMask = bitMask shr 1
            }
            return idx
        }

        private fun contains(x: Int): Boolean = prefix(x + 1) - prefix(x) > 0

        private fun add(i0: Int, delta: Int) {
            var i = i0 + 1
            while (i <= n) {
                bit[i] += delta
                i += i and -i
            }
        }

        private fun prefix(i0: Int): Int {
            var i = i0
            var total = 0
            while (i > 0) {
                total += bit[i]
                i -= i and -i
            }
            return total
        }
    }

    private class BIT(n: Int) {
        private val bit = LongArray(n + 1)

        fun add(i0: Int, value: Int) {
            var i = i0 + 1
            while (i < bit.size) {
                bit[i] = (bit[i] + value) % MOD
                i += i and -i
            }
        }

        fun query(i0: Int): Long {
            var i = i0 + 1
            var total = 0L
            while (i > 0) {
                total = (total + bit[i]) % MOD
                i -= i and -i
            }
            return total
        }
    }

    companion object {
        private const val MOD = 1000000007L
    }
}
