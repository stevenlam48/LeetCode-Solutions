package maximumstrongpairxori

// Time:  O(nlogn + nlogr) = O(nlogr), r = max(nums)
// Space: O(t)

class Solution {
    fun maximumStrongPairXor(nums: IntArray): Int {
        val a = nums.sortedArray()
        val trie = Trie(bitLength(a.last()))
        var result = 0
        var j = 0
        for (i in a.indices) {
            trie.update(a[i], 1)
            while (!(a[i].toLong() <= 2L * a[j])) {
                trie.update(a[j], -1)
                j++
            }
            result = maxOf(result, trie.query(a[i]))
        }
        return result
    }

    private fun bitLength(x: Int): Int = if (x != 0) 32 - Integer.numberOfLeadingZeros(x) else 0

    private class Trie(private val bitLength: Int) {
        private val nodes = ArrayList<IntArray>()
        private val cnts = ArrayList<Int>()

        init {
            newNode()
        }

        fun update(num: Int, d: Int) {
            var curr = 0
            for (i in bitLength - 1 downTo 0) {
                val b = (num shr i) and 1
                if (nodes[curr][b] == -1) {
                    nodes[curr][b] = newNode()
                }
                curr = nodes[curr][b]
                cnts[curr] += d
            }
        }

        fun query(num: Int): Int {
            var result = 0
            var curr = 0
            for (i in bitLength - 1 downTo 0) {
                result = result shl 1
                val b = (num shr i) and 1
                val other = 1 xor b
                if (nodes[curr][other] != -1 && cnts[nodes[curr][other]] > 0) {
                    result = result or 1
                    curr = nodes[curr][other]
                } else {
                    curr = nodes[curr][b]
                }
            }
            return result
        }

        private fun newNode(): Int {
            nodes.add(intArrayOf(-1, -1))
            cnts.add(0)
            return nodes.size - 1
        }
    }
}
