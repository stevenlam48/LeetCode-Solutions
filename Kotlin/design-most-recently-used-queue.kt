package designmostrecentlyusedqueue

// Time:  ctor:  O(n + m), m is the max number of calls
// Space: fetch: O(log(n + m))

class MRUQueue(n: Int) {
    private val bit = BIT(n)
    private val lookup = HashMap<Int, Int>()
    private var curr = n

    init {
        for (i in 0 until n) {
            lookup[i] = i + 1
        }
    }

    fun fetch(k: Int): Int {
        val pos = bit.binaryLift(k)
        val value = lookup[pos]!!
        lookup.remove(pos)
        bit.add(pos, -1)
        bit.add(curr, 1)
        lookup[curr++] = value
        return value
    }

    private class BIT(n: Int) {
        private val bit = IntArray(n + MAX_CALLS + 1)

        init {
            for (i in 1 until bit.size) {
                bit[i] = (if (i - 1 < n) 1 else 0) + bit[i - 1]
            }
            for (i in bit.size - 1 downTo 1) {
                val lastI = i - lowerBit(i)
                bit[i] -= bit[lastI]
            }
        }

        fun add(i: Int, value: Int) {
            var idx = i + 1
            while (idx < bit.size) {
                bit[idx] += value
                idx += lowerBit(idx)
            }
        }

        fun query(i: Int): Int {
            var idx = i + 1
            var total = 0
            while (idx > 0) {
                total += bit[idx]
                idx -= lowerBit(idx)
            }
            return total
        }

        fun binaryLift(k: Int): Int {
            var total = 0
            var pos = 0
            for (i in floorLog2(bit.size - 1) downTo 0) {
                val next = pos + (1 shl i)
                if (next < bit.size && !(total + bit[next] >= k)) {
                    total += bit[next]
                    pos = next
                }
            }
            return pos
        }

        private fun lowerBit(i: Int): Int = i and -i

        private fun floorLog2(x: Int): Int = 31 - Integer.numberOfLeadingZeros(x)

        companion object {
            private const val MAX_CALLS = 2000
        }
    }
}
