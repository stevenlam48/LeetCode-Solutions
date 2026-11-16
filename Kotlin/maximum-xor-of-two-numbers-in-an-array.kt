package maximumxoroftwonumbersinanarray

// Time:  O(nlogr), r = max(nums)
// Space: O(t)

class Solution {
    private class Trie(private val bitLength: Int) {
        private val nodes = ArrayList<IntArray>()

        init {
            new_node()
        }

        fun insert(num: Int) {
            var curr = 0
            for (i in bitLength - 1 downTo 0) {
                val x = num shr i
                val b = x and 1
                if (nodes[curr][b] == -1) {
                    nodes[curr][b] = new_node()
                }
                curr = nodes[curr][b]
            }
        }

        fun query(num: Int): Int {
            var result = 0
            var curr = 0
            for (i in bitLength - 1 downTo 0) {
                result = result shl 1
                val x = num shr i
                val b = x and 1
                if (nodes[curr][1 xor b] != -1) {
                    result = result or 1
                    curr = nodes[curr][1 xor b]
                } else {
                    curr = nodes[curr][b]
                }
            }
            return result
        }

        private fun new_node(): Int {
            nodes.add(intArrayOf(-1, -1))
            return nodes.size - 1
        }
    }

    fun findMaximumXOR(nums: IntArray): Int {
        val trie = Trie(bitLength(nums.max()))
        var result = 0
        for (num in nums) {
            trie.insert(num)
            result = maxOf(result, trie.query(num))
        }
        return result
    }

    private fun bitLength(x: Int): Int {
        return if (x != 0) 32 - Integer.numberOfLeadingZeros(x) else 1
    }
}
