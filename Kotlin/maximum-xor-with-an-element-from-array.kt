package maximumxorwithanelementfromarray

// Time:  O(nlogn + mlogm + nlogk + mlogk), k is max(max(nums), max(xi))
// Space: O(nlogk)

class Solution {
    private class Trie(private val bitLength: Int) {
        private val nodes = ArrayList<IntArray>()

        init {
            nodes.add(intArrayOf(0, 0))
        }

        fun insert(num: Int) {
            var idx = 0
            for (i in bitLength downTo 0) {
                val curr = (num shr i) and 1
                if (nodes[idx][curr] == 0) {
                    nodes.add(intArrayOf(0, 0))
                    nodes[idx][curr] = nodes.size - 1
                }
                idx = nodes[idx][curr]
            }
        }

        fun query(num: Int): Int {
            if (nodes.size == 1) {
                return -1
            }
            var result = 0
            var idx = 0
            for (i in bitLength downTo 0) {
                val curr = (num shr i) and 1
                if (nodes[idx][1 xor curr] != 0) {
                    idx = nodes[idx][1 xor curr]
                    result = result or (1 shl i)
                } else {
                    idx = nodes[idx][curr]
                }
            }
            return result
        }
    }

    fun maximizeXor(nums: IntArray, queries: Array<IntArray>): IntArray {
        nums.sort()
        var maxVal = nums.last()
        for (q in queries) {
            maxVal = maxOf(maxVal, q[0])
        }
        val qs = Array(queries.size) { intArrayOf(it, queries[it][0], queries[it][1]) }
        qs.sortBy { it[2] }
        val result = IntArray(queries.size)
        val trie = Trie(bitLength(maxVal))
        var j = 0
        for (q in qs) {
            val i = q[0]
            val x = q[1]
            val m = q[2]
            while (j < nums.size && nums[j] <= m) {
                trie.insert(nums[j])
                j++
            }
            result[i] = trie.query(x)
        }
        return result
    }

    private fun bitLength(x: Int): Int {
        return if (x != 0) 32 - Integer.numberOfLeadingZeros(x) else 1
    }
}
